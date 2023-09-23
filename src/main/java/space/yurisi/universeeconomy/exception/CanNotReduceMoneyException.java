package space.yurisi.universeeconomy.exception;

public class CanNotReduceMoneyException extends Exception{
    public CanNotReduceMoneyException(){
        super();
    }

   public CanNotReduceMoneyException(String message){
       super(message);
   }
}
