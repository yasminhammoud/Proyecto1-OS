package mattelfactory;

import java.util.concurrent.Semaphore;

/**
 * Representa al Ensamblador de la fábrica
 * 
 * @author Valeria_Yasmin
 */
public class Assembler extends Thread {
    
     /**
     * 
     * Variables utilizadas
     * 
     * MutexPanaProducer: semáforo Mutex de los productores de Panas (Ensamblador)
     * MutexButtonProducer: semáforo Mutex de los productores de botones
     * MutexLegProducer: semáforo Mutex de los productores de piernas
     * MutexArmProducer: semáforo Mutex de los productores de brazos
     * MutexBodyProducer: semáforo Mutex de los productores de cuerpo
     * 
     * semButtonConsumer: semáforo para consumir botones
     * semButtonProducer: semáforo para producir botones
     * semLegsConsumer: semáforo para consumir piernas 
     * semLegsProducer: semáforo para producir piernas
     * semBodyConsumer: semáforo para consumir cuerpos
     * semBodyProducer: semáforo para producir cuerpos
     * semArmsConsumer: semáforo para consumir brazos
     * semArmsProducer: semáforo para producir brazos
     * 
     * name: nombre para identificar el ensamblador trabajando
     * hired: indica si el ensamblador fue contratado
     * duration: duración del día en milisegundos
     * 
     * 
     * Factory.BodyStock: cantidad de cuerpos en el almacén   (Está en la clase Factory)
     * Factory.LegStock: cantidad de piernas en el almacén      (Está en la clase Factory)
     * Factory.ButtonStock: cantidad de botones en el almacén (Está en la clase Factory)
     * Factory.ArmStock: cantidad de brazos en el almacén      (Está en la clase Factory)
     * Factory.PanaStock: cantidad de Panas en el almacén     (Está en la clase Factory)
     * AmountOfPana: cantidad de Panas producidos               (Está en la clase Interface)
     * 
     */
    
    //Mutex of each producer
    Semaphore MutexPanaProducer;
    Semaphore MutexButtonProducer;
    Semaphore MutexLegProducer;
    Semaphore MutexArmProducer;
    Semaphore MutexBodyProducer;
    
    //Semaphores of each producer
    Semaphore SemButtonConsumer;                      
    Semaphore SemButtonProducer; 
   
    Semaphore SemLegsConsumer;                      
    Semaphore SemLegsProducer;   
   
    Semaphore SemArmsConsumer;                      
    Semaphore SemArmsProducer;   
   
    Semaphore SemBodyConsumer;                      
    Semaphore SemBodyProducer;  
    
    //Name of producer
    String name;  
   
    //Duration of days
    int duration;
    
    //If hired
    boolean hired = true;
   
    /**
     *Constructor
     * @param name nombre para identificar el productor
     * @param MutexPanaProducer semáforo Mutex de los productores de Panasn (ensambladores)
     * @param SemButtonsConsumer semáforo para consumir botones
     * @param SemButtonsProducer semáforo para producir botones
     * @param SemArmsConsumer semáforo para consumir brazos
     * @param SemArmsProducer semáforo para producir brazos
     * @param SemLegsConsumer semáforo para consumir piernas
     * @param SemLegsProducer semáforo para producir piernas
     * @param SemBodiesConsumer semáforo para consumir cuerpos
     * @param SemBodiesProducer semáforo para producir cuerpos
     * @param mutexButtonProducer semáforo Mútex de los productores de botones
     * @param mutexLegProducer semáforo Mútex de los productores de piernas
     * @param mutexArmProducer semáforo Mútex de los productores de brazos
     * @param mutexBodyProducer semáforo Mútex de los productores de cuerpos
     */
    public Assembler (String name, Semaphore MutexPanaProducer, Semaphore SemButtonsConsumer, 
            Semaphore SemButtonsProducer ,Semaphore SemArmsConsumer , Semaphore SemArmsProducer ,
            Semaphore SemLegsConsumer, Semaphore SemLegsProducer, Semaphore SemBodiesConsumer, 
            Semaphore SemBodiesProducer, Semaphore mutexButtonProducer , Semaphore mutexLegProducer, 
            Semaphore mutexArmProducer, Semaphore mutexBodyProducer) {
       
        this.name = name;
        this.MutexPanaProducer = MutexPanaProducer;
        this.SemButtonConsumer = SemButtonsConsumer ;
        this.SemButtonProducer = SemButtonsProducer ;
        this.SemLegsConsumer = SemLegsConsumer ;
        this.SemLegsProducer = SemLegsProducer;
        this.SemArmsConsumer = SemArmsConsumer ;
        this.SemArmsProducer = SemArmsProducer ;
        this.SemBodyConsumer = SemBodiesConsumer ;
        this.SemBodyProducer = SemBodiesProducer;
        this.MutexButtonProducer = mutexButtonProducer;
        this.MutexLegProducer = mutexLegProducer;
        this.MutexArmProducer = mutexArmProducer;
        this.MutexBodyProducer = mutexBodyProducer;
        this.duration= Factory.duration;
    }
   
    
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del Assembler. Si cada almacén 
     * tiene las partes de Pana necesarias, se procede a darle acceso al ensamblador para construir un pana. 
     * Luego, se hace acquire de los semáforos consumidores y Mútex para disminuir la cantidad de productos 
     * en su respectivo Stock. Luego, se hace un release de todos los mutex de los productores, así como también 
     * a los semáforos de productores de cada tipo. 
     * Una vez culminado el día, se hace un acquire al mutex de ensambladores,se aumenta la cantidad de panas 
     * en almacen, para luego proceder hacer un release de dicho semáforo.
     *
     */
    
    public void run(){
        while(hired){
            try {
                
                if (Factory.ButtonStock>=8 && Factory.ArmStock>=2 && Factory.LegStock >= 2 && Factory.BodyStock >= 1) {
                    
                this.SemButtonConsumer.acquire(8);  // 8 Buttons 
                this.SemArmsConsumer.acquire(2);    // 2 arms
                this.SemLegsConsumer.acquire(2);    // 2 legs
                this.SemBodyConsumer.acquire();    // 1 body

                this.MutexButtonProducer.acquire();
                this.MutexBodyProducer.acquire();
                this.MutexArmProducer.acquire();
                this.MutexLegProducer.acquire();
                
                Factory.ButtonStock = Factory.ButtonStock - 8;
                Interface.AmountOfButtons.setText(Integer.toString(Factory.ButtonStock));
                
                Factory.BodyStock--;
                Interface.AmountOfBodies.setText(Integer.toString(Factory.BodyStock));
                
                Factory.ArmStock = Factory.ArmStock - 2;
                Interface.AmountOfArms.setText(Integer.toString(Factory.ArmStock)); 
                
                Factory.LegStock = Factory.LegStock - 2;
                Interface.AmountOfLegs.setText(Integer.toString(Factory.LegStock));
                
               this.MutexLegProducer.release();
               this.MutexArmProducer.release();
               this.MutexBodyProducer.release();
               this.MutexButtonProducer.release();
                
                this.SemBodyProducer.release();       // 1 body    
                this.SemLegsProducer.release(2);     // 2 legs 
                this.SemArmsProducer.release(2);     // 2 arms
                this.SemButtonProducer.release(8);   // 8 buttons 
                 
                Thread.sleep(duration);
                
                this.MutexPanaProducer.acquire();
                Factory.PanaStock++;
                Interface.AmountOfPana.setText(Integer.toString(Factory.PanaStock));
                System.out.println(Factory.PanaStock +" panas in stock,  "+Factory.ButtonStock+" buttons in stock, "+Factory.BodyStock+" bodies in stock,  "+Factory.LegStock+" legs in stock, "+Factory.ArmStock+" arms in stock.");
                this.MutexPanaProducer.release();
                }
            } catch (InterruptedException ex) { System.out.println("Error en la producción de Panas"); }
        }
    }
}
