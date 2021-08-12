package HomeWork;


  public class Arrays {
      public static void main(String[] args) {
          int result = 0;

          String[][] array = {
                  {"1","1","1","1"},
                  {"1","1","1","1"},
                  {"1","1","1","1"},
                  {"1","1","1","1"}};
          String[][] error_array = {
                  {"1","2","3","4","1"},
                  {"1","2","3","4"},
                  {"1","2","3","4"},
                  {"1","2","3","4"}
          };
          String[][] error_data = {
                  {"1","1","3","a"},
                  {"1","2","3","4"},
                  {"1","2","3","4"},
                  {"1","2","3","4"}
          };



          System.out.println("Correct Array");
          try {
              result = 0;
              result = analyze(array);
          } catch(MyArraySizeException e){
              System.out.println(e.getMessage());
          } catch(MyArrayDataException e){
              System.out.println(e.getMessage());
          } finally {
              System.out.println("Sum of Array elements "+String.valueOf(result));
              System.out.println("=======================");
          }

          System.out.println("Incorrect Array");
          try {
              result = 0;
              result = analyze(error_array);
          } catch(MyArraySizeException e){
              System.out.println(e.getMessage());
          } catch(MyArrayDataException e){
              System.out.println(e.getMessage());
          } finally {
              System.out.println("Sum of Array elements "+String.valueOf(result));
              System.out.println("=======================");
          }

          System.out.println("Wrong Data");
          try {
              result = 0;
              result = analyze(error_data);
          } catch(MyArraySizeException e){
              System.out.println(e.getMessage());
          } catch(MyArrayDataException e){
              System.out.println(e.getMessage());
          } finally {
              System.out.println("Sum of Array elements "+String.valueOf(result));
              System.out.println("=======================");
          }


      }

      public static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

          int summ = 0;
          int value = 0;
          int row = 0;
          int cell = 0;

          if(array.length != 4 || array[0].length != 4 || array[1].length != 4) {
              throw new MyArraySizeException();
          }

          for(int i=1;i<3;i++){
              row = i;
              for(int j=1;j<5;j++){
                  cell = j;
                  try{
                      value = Integer.parseInt(array[i-1][j-1]);
                      summ += value;
                  } catch (IllegalArgumentException e){
                      String message = "in "+String.valueOf(row)+" Row, "+String.valueOf(cell)+" Cell";
                      throw new MyArrayDataException(message);
                  }
              }
          }

          return summ;
      }
  }


