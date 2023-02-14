
package mattelfactory;
import java.util.concurrent.Semaphore;

/**
 * Esta clase representa al productor de brazos
 * 
 * @author Valeria_Yasmin
 */
public class ArmProducer extends Thread  {
    
    /**
     * 
     * Variables utilizadas
     * 
     * MutexArmProducer: semáforo mútex de los productores de brazos
     * SemArmConsumer: semáforo para consumir brazos
     * SemArmProducer: semáforo para producir brazos
     * duration: duración del día en milisegungos
     * hired: indica si el productor fue contratado
     * name: nombre para identificar el productor 
     * Factory.ArmStock: cantidad de brazos en el almacén (Está en la clase Factory)
     * AmountOfArms: cantidad de brazos producidos          (Está en la clase Interface)
     * 
     */
    
    Semaphore MutexArmProducer;                          
    Semaphore SemArmConsumer;                      
    Semaphore SemArmProducer;
    String name;
    boolean hired = true;      
    int duration;                  
   
    /**
     * Constructor
     * @param name nombre para identificar el productor de brazos trabajando
     * @param MutexArmProducer semáforo mútex de los productores de brazos
     * @param SemArmConsumer semáforo para consumir brazos
     * @param SemArmProducer semáforo para producir brazos
     */
    
    public ArmProducer(String name,Semaphore MutexArmProducer ,Semaphore SemArmConsumer ,Semaphore SemArmProducer){
        this.name = name;
        this.MutexArmProducer = MutexArmProducer ;
        this.SemArmConsumer = SemArmConsumer ;
        this.SemArmProducer = SemArmProducer ;
        this.duration = Factory.duration;  
    }
   
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del productor de brazos. Mientras que esté contrado, 
     * hace un acquire al semáforo del productor para disminuir su margen de producción, tarda una
     * cantidad de días para producir el brazo y luego se aumenta en su almacén. Al aumentar su stock, 
     * se hace un release al mutex de productores de brazos y al semáforo consumidor.
     * 
     */
    
    
    public void run(){
        while (hired) { 
            try {    
                this.SemArmProducer.acquire();
                Thread.sleep(duration);
                this.MutexArmProducer.acquire();
                
                Factory.ArmStock++;
                System.out.println(name+" Unidades almacen de brazos: "+ Factory.ArmStock );
                Interface.AmountOfArms.setText(Integer.toString(Factory.ArmStock));
                
                this.MutexArmProducer.release();
                this.SemArmConsumer.release();
                
            } catch (InterruptedException ex) { System.out.println("Error en la producción de brazos");}
        }
    }
}
