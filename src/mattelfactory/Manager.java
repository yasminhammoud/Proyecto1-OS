package mattelfactory;
import java.util.concurrent.Semaphore;

/**
 * 
 * Representa al Gerente en la fábrica
 * 
 * @author Valeria_Yasmin
 */
public class Manager extends Thread {
    
    /**
     * 
     * Variables utilizadas
     * 
     * MutexBossManager: semáforo Mutex entre el jefe y gerente
     * DaysToDeliver: días restantes para la entrega de Panas
     * MutexAssembler: semáforo Mutex del ensamblador
     * DayDuration: duración del día en milisegundos
     * Factory.counter: contador de la fábrica                                                                      (Está en la clase Factory)
     * Factory.managerStatus: estatus del gerente (Despierto/Durmiendo/Entregando)     (Está en la clase Factory)
     * Factory.PanaStock: cantidad de Panas en el almacén                                              (Está en la clase Factory)
     * AmountOfPana: cantidad de Panas producidos                                                         (Está en la clase Interface)
     * 
     */
    
    int dayDuration;
    int daysToDeliver;
    Semaphore MutexBossManager;
    Semaphore MutexAssembler;

    /**
     *Constructor
     * @param MutexBossManager semáforo Mutex entre el jefe y gerente
     * @param mutexAssembler semáforo Mutex del ensamblador
     */
    public Manager(Semaphore MutexBossManager, Semaphore mutexAssembler) {
       
        this.MutexBossManager  = MutexBossManager;
        this.MutexAssembler = mutexAssembler;
        this.dayDuration = Factory.duration;
        this.daysToDeliver = Factory.daysToDeliver;
    }
    
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del Gerente. 
     * 
     * El Gerente revisa el contador, si este no es igual a 0, se va a dormir por 8 horas y su estatus cambia a "Durmiendo"
     * de "Despierto". De lo contrario, el Gerente cambia su estatus a "Entregando" que se refiere a que se encuentra 
     * entregando Panas. El PanaStock (almacén de Panas) se iguala a 0 y el contador se reinicializa con la cantidad de 
     * días para la próxima entrega. Para resetear la cantidad de Panas producidos que hay en el almácen, se hace un 
     * acquire al mutex del ensamblador, se entregan todos los panas terminados y se finaliza con un release 
     * de dicho semáforo. Cabe agregar, para que el Gerente tenga acceso al contador se hace un acquire al 
     * MutexBossManager, y una vez que finaliza de revisarlo, se hace un release de dicho semáforo.  
     * 
     */
   
    public void run(){
        
        while(true){  
            try {
                
                    this.MutexBossManager.acquire();                   //   check left days
                    Factory.managerStatus = "Despierto";
                    Interface.ManagerStatus.setText(Factory.managerStatus);                   
                    
                    if (Factory.counter == 0) {
                        this.MutexAssembler.acquire();
                        Factory.managerStatus = "Entregando";
                        Interface.ManagerStatus.setText(Factory.managerStatus);
                        Factory.PanaStock = 0;
                        Interface.AmountOfPana.setText(Integer.toString(Factory.PanaStock));
                        Factory.counter = daysToDeliver;
                        Interface.DaysLeft.setText(Integer.toString(Factory.counter));
                        this.MutexAssembler.release();
                    }
                                       
                    this.MutexBossManager.release();
                    Thread.sleep((long) (dayDuration*0.33));
                    Factory.managerStatus = "Durmiendo";
                    Interface.ManagerStatus.setText(Factory.managerStatus);   
        
            } catch (InterruptedException ex) { System.out.println("The manager got fired");}
        }
    }
}