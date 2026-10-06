import java.util.*;

class ThroneInheritance {
    Map<String, List<String>> child = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        child.put(king, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        child.get(parentName).add(childName);
        child.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(king, ans);
        return ans;
    }

    void dfs(String name, List<String> ans) {
        if (!dead.contains(name))
            ans.add(name);

        for (String c : child.get(name))
            dfs(c, ans);
    }
}