package Aspects;

public aspect FirstAspect {
    pointcut pc1(): execution(* Main.Application.m(..));

    // code advice
//    before(): pc1(){
//        System.out.println("**************** Before Main ! *****************");
//    }
//    after(): pc1(){
//        System.out.printf("***************** After Main ! *******************");
//    }

    // code advice around: it is like the before and after without the proceed !
//    void around(): pc1(){
//        System.out.println("Before Main using Around advice !!");
//        proceed(); // the excution of the main method :
//        System.out.println("After Main using Around advice !!");
//    }
}
