import java.util.*;

enum TreeColor { RED, GREEN }

abstract class Tree {
    int v, d;
    TreeColor c;
    Tree(int v, int d, TreeColor c) {
        this.v = v; this.d = d; this.c = c;
    }
    int getValue() { return v; }
    int getDepth() { return d; }
    TreeColor getColor() { return c; }
    abstract void accept(TreeVis x);
}

class TreeNode extends Tree {
    List<Tree> ch = new ArrayList<>();
    TreeNode(int v, int d, TreeColor c) { super(v,d,c); }
    void addChild(Tree x) { ch.add(x); }
    void accept(TreeVis x) {
        x.visitNode(this);
        for(Tree t:ch) t.accept(x);
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int v,int d,TreeColor c) { super(v,d,c); }
    void accept(TreeVis x) { x.visitLeaf(this); }
}

abstract class TreeVis {
    abstract int getResult();
    abstract void visitNode(TreeNode n);
    abstract void visitLeaf(TreeLeaf l);
}

class SumInLeavesVisitor extends TreeVis {
    int s;
    int getResult(){return s;}
    void visitNode(TreeNode n){}
    void visitLeaf(TreeLeaf l){s+=l.v;}
}

class ProductOfRedNodesVisitor extends TreeVis {
    long p=1;
    int getResult(){return (int)p;}
    void visitNode(TreeNode n){if(n.c==TreeColor.RED)p=p*n.v%1000000007;}
    void visitLeaf(TreeLeaf l){if(l.c==TreeColor.RED)p=p*l.v%1000000007;}
}

class FancyVisitor extends TreeVis {
    int a,b;
    int getResult(){return Math.abs(a-b);}
    void visitNode(TreeNode n){if(n.d%2==0)a+=n.v;}
    void visitLeaf(TreeLeaf l){if(l.c==TreeColor.GREEN)b+=l.v;}
}

public class Solution {
    static int[] v,c;
    static List<Integer>[] g;

    static Tree build(int u,int p,int d) {
        TreeColor col=c[u]==0?TreeColor.RED:TreeColor.GREEN;
        TreeNode n=new TreeNode(v[u],d,col);
        boolean leaf=true;

        for(int x:g[u])
            if(x!=p){
                leaf=false;
                n.addChild(build(x,u,d+1));
            }

        if(leaf) return new TreeLeaf(v[u],d,col);
        return n;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();

        v=new int[n];
        c=new int[n];
        g=new ArrayList[n];

        for(int i=0;i<n;i++)g[i]=new ArrayList<>();
        for(int i=0;i<n;i++)v[i]=s.nextInt();
        for(int i=0;i<n;i++)c[i]=s.nextInt();

        for(int i=1;i<n;i++){
            int a=s.nextInt()-1,b=s.nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }

        Tree root=build(0,-1,0);

        TreeVis a=new SumInLeavesVisitor();
        TreeVis b=new ProductOfRedNodesVisitor();
        TreeVis d=new FancyVisitor();

        root.accept(a);
        root.accept(b);
        root.accept(d);

        System.out.println(a.getResult());
        System.out.println(b.getResult());
        System.out.println(d.getResult());
    }
}