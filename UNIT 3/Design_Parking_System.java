class ParkingSystem {
    int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        parking = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (parking[carType - 1] > 0) {
            parking[carType - 1]--;
            return true;
        }
        return false;
    }
}