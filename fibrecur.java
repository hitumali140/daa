//  public class fibiter {

//      public static void fib(int n){
//          int first = 0;
//          int second = 1;
//          for(int i = 0; i < n; i++){
//              System.out.println(first);
//              int third = first + second;
//              first = second;
//              second = third;
//          }
//      }

//      public static void main(String[] args) {
//          int n = 6;
//          fib(n);
//      }
//  }




public class fibrecur {
    public static int fib(int n){
        if(n <= 1){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
        // return n;
    }

    public static void main(String[] args) {
        int n = 6;
        for(int i = 0; i < n; i++){
            System.out.print(fib(i) + " ");
        }
    }
}


