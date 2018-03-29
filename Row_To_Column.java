public class Row_To_Column
{
	public static void main (String args[])
	{
		int arr [][] = new int [5][5];
		int transpose [][] = new int [arr.length][arr.length];
		arr = FillArray(arr);
		transpose = Transpose(arr,transpose);
		PrintArray(arr);
		System.out.println();
		PrintArray(transpose);
	}
	public static void PrintArray(int print [][])
	{
		for(int i =0; i<print.length; i++)
		{
			for(int j=0; j<print.length; j++)
			{
				System.out.print(print[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] FillArray(int arr [][])
	{
		int count =0;
		for(int i =0; i<arr.length; i++)
		{
			for(int j=0; j<arr.length; j++)
			{
				arr[i][j] = count;
				count ++;
			}
		}
		return arr;
	}
	public static int[][] Transpose(int arr[][], int transpose[][])
	{
		if (arr.length > 0)
		{
            for (int i = 0; i < arr.length; i++)
            {
                for (int j = 0; j < arr.length; j++)
                {
                    int holder = arr[i][j];
                    transpose [j][i] = holder;
                }
            }
        }
		return transpose;
	}
}