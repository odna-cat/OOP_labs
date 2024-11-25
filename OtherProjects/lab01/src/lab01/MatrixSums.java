package lab01;
public class MatrixSums {
    public static void main(String[] args) {
        // constant two matrices
        // in this case, two 3x3 matrices
        /*
         * Similar issue with user-defined matrices. However, requires that the size of the matrix
         * be defined beforehand, then define the matrix rows accordingly via a switch-case.
        */
        double[][] matA = {{2.5,25,2},{7.9,2.2,1},{3,8,0}};
        double[][] matB = {{53,53.4,1},{4.64,23.5,7.27},{2.46,-90,100}};

        double[][] sum = new double[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                sum[i][j] = matA[i][j] + matB[i][j];
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }    
}
