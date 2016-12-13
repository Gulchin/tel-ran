package tel_ran.arrays;

import java.util.Arrays;

public class Matrix {
	/*
	 * @param matrix{{1,2,3},{4,5,6}}
	 * @return {{1,4},{2,5},{3,6}}
	 */
	public static int[][] transp(int [][] matrix){
		int [][]result=new int[matrix[0].length][matrix.length];
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix[0].length;i++){
				result[i][j]=matrix[j][i];
			}
		}	
		return result;
	}
	/*
	 * sum of elements
	 */
	public static int sum(int[][]matrix){
		int result=0;
		
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix[0].length;i++){
				result+=matrix[j][i];
			}
		}	
		return result;
	}
	/*
	 * Matrix multiplication should be used on matrixes with proper sizes
	 */
	
	public static int[][]multiply(int[][]matrix1,int[][]matrix2){
		
		if (matrix2.length!=matrix1[0].length) throw new IllegalArgumentException("Wrong matrix dimesions");
		int [][]result=new int [matrix1.length][matrix2[0].length];
		for(int j=0;j<result.length;j++){
			for (int i=0;i<result[0].length;i++){
				result[j][i]=0;
				for(int k=0;k<matrix1[0].length;k++){
					result[j][i]+=matrix1[j][k]*matrix2[k][i];
				}
			}
		}
		return result;
	}
	
	public static double[][]multiply(double[][]matrix1,double[][]matrix2){
		if (matrix2.length!=matrix1[0].length) throw new IllegalArgumentException("Wrong matrix dimesions");
		double [][]result=new double [matrix1.length][matrix2[0].length];
		for(int j=0;j<result.length;j++){
			for (int i=0;i<result[0].length;i++){
				result[j][i]=0;
				for(int k=0;k<matrix1[0].length;k++){
					result[j][i]+=matrix1[j][k]*matrix2[k][i];
				}
			}
		}
		return result;
	}
	/*
	 * Получаем обратную матрицу методом Гаусса-Жордана
	 */
	public static double [][] inversMatrix(double [][] matrix){
		if (matrix.length!=matrix[0].length) throw new IllegalArgumentException("Only square matrixes allowed");
		double [][] ematrix=eMatrix(matrix.length);
		
		for (int i=0;i<matrix.length;i++){
			//Если не смогли поставить ненулевой элемент на диагональ, значит матрица не обартима.
			if (!arrangeDiagonal(i, matrix, ematrix)) return null;
			//Домножаем на 1/aij чтобы получить 1 на диагонали
			multRow(1/matrix[i][i], ematrix[i]);
			multRow(1/matrix[i][i], matrix[i]);

			//Образуем колонку 0 под единицей
			for (int j=i+1;j<matrix.length;j++){
				powerAddRows(-matrix[j][i], ematrix[i], ematrix[j]);
				powerAddRows(-matrix[j][i], matrix[i], matrix[j]);
			}			
		}
		//Образуем колонку 0 над единицей
		for (int i=matrix.length-1;i>=0;i--){
			for(int j=i-1;j>=0;j--){
				powerAddRows(-matrix[j][i], ematrix[i], ematrix[j]);
				powerAddRows(-matrix[j][i], matrix[i], matrix[j]);	
			}
			
		}
		return ematrix;
	}
	/*
	 * Возвращает единичную матрицу заданного размера
	 */
	public static double [][] eMatrix(int size){
		double [][] result=new double [size][size];
		for (int j=0;j<size;j++){
			for (int i=0;i<size;i++){
				if (i==j){
					result[j][i]=1;
				}else result[j][i]=0;
			}

		}
		return result;
	}
	
	public static boolean arrangeDiagonal(int pos, double [][] matrix, double [][]ematrix){
		if (matrix[pos][pos]!=0)return true;
		for(int j=pos+1;j<matrix.length;j++){
			if(matrix[j][pos]!=0){
				swapRows(pos,j,matrix);
				swapRows(pos,j,ematrix);
				return true;
			}
		}
		return false;		
	}
	
	public static void swapRows(int row1,int row2, double[][]matrix){
		double [] buf=matrix[row1];
		matrix[row1]=matrix[row2];
		matrix[row2]=buf;
	}
	
	public static void multRow(double multiplier, double [] row){
		for(int i=0;i<row.length;i++){
			row[i]*=multiplier;
		}
	}
	
	public static void powerAddRows(double multiplier,double[]row1,double[] row2){
		for (int i=0;i<row1.length;i++){
			row2[i]+=multiplier*row1[i];
		}
	}

}
