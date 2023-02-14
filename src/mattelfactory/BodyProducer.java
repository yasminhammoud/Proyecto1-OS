
package mattelfactory;
import java.util.concurrent.Semaphore;

/**
 * Esta clase representa al productor de cuerpos
 * 
 * @author Valeria_Yasmin
 */
public class BodyProducer extends Thread {
    
    /**
     * 
     * Variables utilizadas
     * 
     * MutexBodyProducer: semáforo mútex de los productores de cuerpos
     * SemBodyConsumer: semáforo para consumir cuerpos
     * SemBodyProducer: semáforo para producir cuerpos
     * duration: duración del día en milisegundos
     * hired: indica si el productor de cuerpos fue contratado
     * name: nombre para identificar la cantidad de productos producidos
     * Factory.BodyStock: cantidad de cuerpos en el almacén     (Está en la clase Factory)
     * AmountOfBodies: cantidad de cuerpos producidos             (Está en la clase Interface)         
     */
    
    Semaphore MutexBodyProducer;                          
    Semaphore SemBodyConsumer;                      
    Semaphore SemBodyProducer;
    String name;
    boolean hired = true;
    int duration;
   
    /**
     * Constructor
     * @param name nombre para identificar el productor de cuerpos trabajando
     * @param MutexBodyProducer semáforo mútex de los productores de cuerpos
     * @param SemBodyConsumer semáforo para consumir cuerpos
     * @param SemBodyProducer semáforo para producir cuerpos
     */
    public BodyProducer(String name,Semaphore MutexBodyProducer ,Semaphore SemBodyConsumer ,Semaphore SemBodyProducer){
       
        this.name = name;
        this.MutexBodyProducer = MutexBodyProducer ;
        this.SemBodyConsumer = SemBodyConsumer ;
        this.SemBodyProducer = SemBodyProducer ;
        this.duration= Factory.duration;
    }
   
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del productor de cuerpos. Mientras que esté contrado, 
     * hace un acquire al semáforo del productor para disminuir su margen de producción, tarda una
     * cantidad de días para producir el cuerpo y luego se aumenta en su almacén. Al aumentar su stock, 
     * se hace un release al mutex de productores de cuerpos y al semáforo consumidor.
     * 
     */
    
    
    public void run(){
       
        while(hired){
            try {
                this.SemBodyProducer.acquire();
                Thread.sleep(duration*3);
                this.MutexBodyProducer.acquire();
                
                Factory.BodyStock++;
                System.out.println(name + " Unidades almacen de cuerpo: "+ Factory.BodyStock );
                Interface.AmountOfBodies.setText(Integer.toString(Factory.BodyStock));
                
                this.MutexBodyProducer.release();
                this.SemBodyConsumer.release();
                
            } catch (InterruptedException ex) { System.out.println("Error en la producción de Cuerpos Centrales"); }
        }
    }
}
