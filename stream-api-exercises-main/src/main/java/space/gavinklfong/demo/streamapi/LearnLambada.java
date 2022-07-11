package space.gavinklfong.demo.streamapi;

@FunctionalInterface
interface MyFunctionInterface{
    // A method with no parameter
    String sayHellO(String s1,String s2);

    default String sayHellO1(String args){
        //System.out.println(args+1);
        return args+1;
    };

    static String sayHello2(String args){
        return args+"Static";
    }
}

 class Example{

    public static void main(String[] args) {
        // lambada expression

        MyFunctionInterface myFunctionInterface  = (s1,s2) -> {
            return s1 + s2;
        };

        System.out.println(myFunctionInterface.sayHellO("Sudhir","PA"));
        System.out.println(myFunctionInterface.sayHellO1("Sudhir"));

        MyFunctionInterface.sayHello2("Sudhir");
    }
}