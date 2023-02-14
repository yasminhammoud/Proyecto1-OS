
package mattelfactory;
import java.util.concurrent.Semaphore;

/**
 * Esta clase representa al Jefe
 * 
 * @author Valeria_Yasmin
 */
public class Boss extends Thread {
    
 /**Variables utilizadas
 * 
 * Factory.counter: contador de la fábrica                                     (Está en la clase Factory)
 * Factory.bossStatus: estatus del jefe (Despierto/Durmiendo)    (Está en la clase Factory)
 * duration: duración del día en milisegundos
 * MutexBossManager: semáforo entre el Jefe y Gerente
 * BossStatus: estado actual del jefe                                            (Está en la clase Interface)
 * 
 */
    
    int duration;
    Semaphore MutexBossManager;
   
    /**
     * Constructor
     *
     * @param MutexBossManager semáforo entre Jefe y Gerente
     * 
     */
    public Boss(Semaphore MutexBossManager){
       
        this. MutexBossManager = MutexBossManager  ;
        this.duration = Factory.duration;
    }
   
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del Jefe. 
     * El Jefe disminuye el contador por 8 horas y al culminar dicho tiempo, su estado
     * pasa a "Durmiendo" de "Despierto. Para esto, se hace acquire al semáforo 
     * MutexBossManager y cuando finalice su jornada de trabajo se hace un release 
     * de dicho semáforo. Luego, el Jefe duerme por 16 horas, para volver a iniciar su día. 
     * 
     */
    public void run() {
        try {
            while (true) {

                this.MutexBossManager.acquire();
                    
                Factory.bossStatus = "Despierto";
                Interface.BossStatus.setText(Factory.bossStatus);
                Thread.sleep((long) (duration*0.33));  
                
                if  (Factory.counter > 0) {
                    Factory.counter--; 
                    Interface.DaysLeft.setText(Integer.toString(Factory.counter));
                }
                
                this.MutexBossManager.release(); 
                Factory.bossStatus = "Durmiendo";
                Interface.BossStatus.setText(Factory.bossStatus);
                Thread.sleep( (long) (duration* 0.66));
                }
         } catch (InterruptedException ex) { System.out.println("The boss is messing around"); }
    }
}
