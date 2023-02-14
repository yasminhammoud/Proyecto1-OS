
package mattelfactory;

import java.util.concurrent.Semaphore;

/**
 * 
 * Esta clase representa al productor de botones
 * 
 * @author Valeria_Yasmin
 */
public class ButtonProducer extends Thread {

    /**
     * 
     * Variables utilizadas
     * 
     * MutexButtonProducer: semáforo mútex de los productores de botones
     * SemButtonConsumer: semáforo para consumir botones
     * SemButtonProducer: semáforo para producir botones
     * duration: duración del día en milisegundos
     * hired: indica si el productor de botones fue contratado
     * name: nombre para identificar el productor de botones trabajando
     * Factory.ButtonStock: cantidad de botones en el almacén     (Está en la clase Factory)
     * AmountOfButtons: cantidad de botones producidos              (Está en la clase Interface)
     * 
     */
    
    Semaphore MutexButtonProducer;
    Semaphore SemButtonConsumer;
    Semaphore SemButtonProducer;
    String name;
    boolean hired = true;
    int duration;

    /**
     *Constructor
     * @param name nombre para identificar la cantidad de productos producidos
     * @param MutexButtonProducer semáforo mútex de los productores de botones
     * @param SemButtonConsumer semáforo para consumir botones
     * @param SemButtonProducer semáforo para producir botones
     */
    
    public ButtonProducer(String name, Semaphore MutexButtonProducer, Semaphore SemButtonConsumer, Semaphore SemButtonProducer) {
        this.name = name;
        this.MutexButtonProducer = MutexButtonProducer;
        this.SemButtonConsumer = SemButtonConsumer;
        this.SemButtonProducer = SemButtonProducer;
        this.duration = Factory.duration;
    }
        
    
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del productor de botones. Mientras que esté contrado, 
     * hace un acquire al semáforo del productor para disminuir su margen de producción, tarda una
     * cantidad de días para producir el cuerpo y luego se aumenta en su almacén. Al aumentar su stock, 
     * se hace un release al mutex de productores de cuerpos y al semáforo consumidor.
     * 
     */
    
        public void run() {
            while (hired) {
                try {
                    this.SemButtonProducer.acquire();
                    Thread.sleep((long) (duration * 0.25));
                    this.MutexButtonProducer.acquire();
                
                    Factory.ButtonStock++;
                    System.out.println(name + " Unidades almacen de botones: " + Factory.ButtonStock);
                    Interface.AmountOfButtons.setText(Integer.toString(Factory.ButtonStock));
                
                    this.MutexButtonProducer.release();
                    this.SemButtonConsumer.release();

                } catch (InterruptedException ex) {System.out.println("Error en la producción de Botones"); }
            }
    }
}
