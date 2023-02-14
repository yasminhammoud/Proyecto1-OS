package mattelfactory;

import java.util.concurrent.Semaphore;

/**
 * Esta clase representa al productor de piernas
 * 
 * @author Valeria_Yasmin
 */
public class LegProducer extends Thread {

    /**
     * 
     * Variables utilizadas
     * 
     * MutexLegProducer: semáforo mútex de los productores de piernas
     * SemLegConsumer: semáforo para consumir piernas
     * SemLegProducer: semáforo para producir piernas
     * duration: duración del día en milisegundos
     * hired: indica si el productor de piernas fue contratado
     * name: nombre para identificar el productor de piernas trabajando
     * Factory.LegStock: cantidad de piernas en el almacén     (Está en la clase Factory) 
     * AmountOfLegs: cantidad de piernas producidas              (Está en la clase Interface)
     * 
     */
    
    Semaphore MutexLegProducer;
    Semaphore SemLegConsumer;
    Semaphore SemLegProducer;
    String name;
    boolean hired = true;
    int duration;

    /**
     *Constructor
     * @param name nombre para identificar el productor de piernas trabajando
     * @param MutexLegProducer semáforo mútex de los productores de piernas
     * @param SemLegConsumer semáforo para consumir piernas
     * @param SemLegProducer semáforo para producir piernas
     */
    
    public LegProducer(String name, Semaphore MutexLegProducer, Semaphore SemLegConsumer, Semaphore SemLegProducer) {

        this.name = name;
        this.MutexLegProducer = MutexLegProducer;
        this.SemLegConsumer = SemLegConsumer;
        this.SemLegProducer = SemLegProducer;
        this.duration = Factory.duration;
    }
    
    /**
     * Método run para comenzar a correr el thread.
     * 
     * Este método representa la funcionalidad del productor de piernas. Mientras que esté contrado, 
     * hace un acquire al semáforo del productor para disminuir su margen de producción, tarda una
     * cantidad de días para producir la pierna y luego se aumenta en su almacén. Al aumentar su stock, 
     * se hace un release al mutex de productores de piernas y al semáforo consumidor.
     * 
     */

    public void run() {
        while (hired) {
            try {
                SemLegProducer.acquire();
                Thread.sleep(duration * 2);
                MutexLegProducer.acquire();
                
                Factory.LegStock++;
                System.out.println(name + " Unidades almacen de piernas: " + Factory.LegStock);
                
                Interface.AmountOfLegs.setText(Integer.toString(Factory.LegStock));
                this.MutexLegProducer.release();
                this.SemLegConsumer.release();
                
            } catch (InterruptedException ex) { System.out.println("Error en la producción de Piernas"); }
        }
    }
}
