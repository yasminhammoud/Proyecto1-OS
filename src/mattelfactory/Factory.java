
package mattelfactory;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.util.concurrent.Semaphore;


/**
 * Representa la fábrica de Panas
 *
 * @author Valeria_Yasmin
 */
public class Factory {
    
    /*Variables utilizadas
     * 
     * 
     * duration: duración del día en milisegundos
     * daysToDeliver: días restantes para la entrega de Panas
     * 
     * maxProdButtons: máxima cantidad de productores de botones
     * maxStockButtons: máxima cantidad de botones en el almacén
     * initialProdButtons: cantidad inicial de productores de botones
     * 
     * maxProdArms: máxima cantidad de productores de brazos
     * maxStockArms: máxima cantidad de brazos en el almacén
     * initialProdArms: cantidad inicial de productores de brazos
     * 
     * maxProdLegs: máxima cantidad de productores de piernas
     * maxStockLegs: máxima cantidad de piernas en el almacén
     * initialProdLegs: cantidad inicial de productores de piernas
     * 
     * maxProdBody: máxima cantidad de productores de cuerpos
     * maxStockBody: máxima cantidad de cuerpos en el almacén
     * initialProdBody: cantidad inicial de productores de cuerpos
     * 
     * initialProdAssembler: cantidad inicial de ensambladores
     * maxProdAssembler: cantidad máxima de ensambladores
     * 
     * bossStatus: estatus del jefe
     * managerStatus: estatus del gerente
     * 
     * ButtonStock: almacén de la cantidad actual de botones 
     * ArmStock: almacén de la cantidad  actual de brazos
     * LegStock: almacén de la cantidad actual de piernas
     * BodyStock: almacén de la cantidad  actual de cuerpos
     * PanaStock: almacén de la cantidad actual de panas
     * 
     * actualButtonProd: cantidad actual de productores de botones trabajando
     * actualLegProd: cantidad actual de productores de piernas trabajando
     * actualArmProd: cantidad actual de productores de brazos trabajando
     * actualBodyProd: cantidad actual de productores de cuerpos trabajando
     * actualPanaProd: cantidad actual de productores de Panas trabajando
     * 
     * MutexBossManager: semáforo Mutex entre el jefe y gerente
     * MutexAssembler: semáforo Mutex del ensamblador
     * MutexPanaProducer: semáforo Mutex de los productores de Panas (ensamblador)
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
     * semBodyProducer:semáforo para producir cuerpos
     * semArmsConsumer: semáforo para consumir brazos
     * semArmsProducer: semáforo para producir brazos
     * 
     * buttonProducers: array de productores de botones
     * armProducers: array de productores de brazos
     * legProducers: array de productores de piernas
     * bodyProducers: array de productores de cuerpos
     * panaProducers: array de productores de panas
     * 
     * 
     * begin: para comenzar la simulación
     * counter: contador de días (refleja el pasar de los días hasta la fecha de entrega)
    
    */
    
    
    public static int duration;
   
    public static int daysToDeliver;
    
    public static int maxProdButtons;   

    public static int maxStockButtons;
    
    public static int initialProdButtons;   
    
    public static int maxProdLegs;

    public static int maxStockLegs;

    public static int initialProdLegs;
    
    public static int maxProdArms;
   
    public static int maxStockArms;

    public static int initialProdArms;
    
    public static int maxProdBody;

    public static int maxStockBody;

    public static int initialProdBody;
    
    public static int initialProdAssembler;

    public static int maxProdAssembler;
    
    public static volatile String bossStatus = "Iniciando";

    public static volatile String managerStatus = "Iniciando";
    
    
    // Stocks of each type of product
    public static volatile int ButtonStock = 0;

    public static volatile int ArmStock = 0;

    public static volatile int LegStock = 0;

    public static volatile int BodyStock = 0;

    public static volatile int PanaStock = 0;
    
    // Actual amount of producers of each type
    int actualButtonProd = 0;  
    int actualLegProd = 0;
    int actualArmProd = 0;
    int actualBodyProd = 0;
    int actualPanaProd = 0;
    
    // Semaphores for each producer:
    
    // Button
    Semaphore semButtonProducer;
    Semaphore semButtonConsumer;
    Semaphore mutexButtonProducer;
    
    // Leg
    Semaphore semLegProducer;
    Semaphore semLegConsumer;
    Semaphore mutexLegProducer;
    
    // Arm
    Semaphore semArmProducer;
    Semaphore semArmConsumer;
    Semaphore mutexArmProducer;
    
    // Body
    Semaphore semBodyProducer;
    Semaphore semBodyConsumer;
    Semaphore mutexBodyProducer;
    
    // Pana
    Semaphore mutexPanaProducer;
    
    // Boss - Manager
    Semaphore mutexBossManager;
    
    // Arrays for each producer 
    ButtonProducer[] buttonProducers;
    ArmProducer[] armProducers;
    LegProducer[] legProducers;
    BodyProducer[] bodyProducers;
    Assembler[] panaProducers;
    
   //Counter
    public static volatile int counter;

    //Begin production
    public static volatile boolean begin  = false;
    
    /**
     * Metodo para leer el txt.
     * 
     *En este metodo se validan los distintos casos de escritura del enunciado y se 
     * registran las cantidades iniciales y máximas de productores y productos, así
     * como también la duración del día y los días para entregar Panas. 
     * 
     * 
     */
    
    public void ReadTxt(){
        
        // Estas variables tienen la misma función, la cual es comprobar si ha registrado correctamente
        // todos los datos requeridos para que corra la simulación sin ningun inconveniente
        
        boolean assemblerVer, bodyVer, armVer, legVer , dayDurationVer , buttonVer , dayDeliverVer;
        assemblerVer = bodyVer = armVer = legVer = dayDurationVer = buttonVer = dayDeliverVer = false;
        
        String line;                   // Linea del archivo txt
        String lineContent[];    // Almacena el contenido de la línea correspondida del archivo txt
        String numbers[];        // Almacena contenido númerico del arreglo lineContent 
        
        try{
            
            File Archivo = new File("Archivo.txt");
            BufferedReader bf = new BufferedReader(new FileReader(Archivo));
           
            while ((line = bf.readLine()) != null) {
               
                if(!line.equals("")){
                    lineContent = line.split(":"); 
                    if (lineContent[0].equals("Ensambladores (cantidad inicial, cantidad máxima)")){
                        numbers = lineContent[1].split(",");
                        initialProdAssembler = Integer.parseInt(numbers[0]);
                        maxProdAssembler = Integer.parseInt(numbers[1]);
                        assemblerVer = true;
                    }
                    // Se registra la duración del día
                    else if (lineContent[0].equals("Duración de un día en segundos")){
                        duration = Integer.parseInt(lineContent[1]) * 1000;
                        dayDurationVer  = true;
                    }
                    // Se registra la cantidad de días entre cada entrega de Panas
                    else if (lineContent[0].equals("Cantidad de días entre despachos")){
                        daysToDeliver = Integer.parseInt(lineContent[1]);
                        dayDeliverVer = true;
                    }
                    // Registro de la información para la producción de botones
                    else if (lineContent[0].equals("Botones (cantidad máxima almacen, cantidad inicial de productores, cantidad máxima de productores)")){
                        numbers = lineContent[1].split(",");
                        maxStockButtons= Integer.parseInt(numbers[0]);
                        initialProdButtons = Integer.parseInt(numbers[1]);
                        maxProdButtons = Integer.parseInt(numbers[2]);
                        buttonVer = true;
                    }
                     // Registro de la información para la producción de brazos
                    else if (lineContent[0].equals("Brazos (cantidad máxima almacen, cantidad inicial de productores, cantidad máxima de productores)")){
                        numbers = lineContent[1].split(",");
                        maxStockArms= Integer.parseInt(numbers[0]);
                        initialProdArms = Integer.parseInt(numbers[1]);
                        maxProdArms = Integer.parseInt(numbers[2]);
                        armVer = true;
                    }
                     // Registro de la información para la producción de piernas
                    else if (lineContent[0].equals("Piernas (cantidad máxima almacen, cantidad inicial de productores, cantidad máxima de productores)")){
                        numbers = lineContent[1].split(",");
                        maxStockLegs= Integer.parseInt(numbers[0]);
                        initialProdLegs = Integer.parseInt(numbers[1]);
                        maxProdLegs = Integer.parseInt(numbers[2]);
                        legVer = true; 
                    }
                     // Registro de la información para la producción de cuerpos
                    else if (lineContent[0].equals("Cuerpo (cantidad máxima almacen, cantidad inicial de productores, cantidad máxima de productores)")){
                        numbers = lineContent[1].split(",");
                        maxStockBody= Integer.parseInt(numbers[0]);
                        initialProdBody = Integer.parseInt(numbers[1]);
                        maxProdBody = Integer.parseInt(numbers[2]);
                        bodyVer = true;
                    }
                else {JOptionPane.showMessageDialog(null,"Por favor, escriba correctamente los enunciados"); 
                }  }   }
                  
            // Verficar que los datos númericos almacenados en las respectivas variables sean las adecuadas
            
            if (maxProdBody < initialProdBody || initialProdBody < 0 || maxProdBody < 1  ||  maxStockBody < 1){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
            }
            else if (maxProdArms < initialProdArms || initialProdArms < 0 || maxProdArms < 1 || maxStockArms < 2){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
            }
            else if (maxProdLegs < initialProdLegs || initialProdLegs < 0 || maxProdLegs < 1 || maxStockLegs < 2){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
            }
            else if (maxProdButtons < initialProdButtons || initialProdButtons < 0 || maxProdButtons < 1 || maxStockButtons < 8){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
            }
             else if (maxProdAssembler < initialProdAssembler || initialProdAssembler < 0 || maxProdAssembler < 1){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
            }
            else if (duration <= 0){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
                }
            else if (daysToDeliver <= 0){
                JOptionPane.showMessageDialog(null,"Datos ingresados no son válidos\n Por favor, verifique");
                }
            // Si todas las variables tienen almacenado un dato númerico proveniente del txt, entonces se puede iniciar la simulación
            else if (assemblerVer && bodyVer && armVer && legVer && dayDurationVer && buttonVer && dayDeliverVer) {
                     begin = true; 
            }    
             bf.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo problemas en la lectura de la base de datos.\nPor favor, ingrese números enteros no negativos. \n Asegurese que no falte ningún dato");
        }
    }
    
    /**
     * Método para iniciar la producción.
     * 
     * Si todo esta correcto en el método anterior, se inicia la producción. En
     * este método se inicializan los semáforos, productores, contador y se
     * establece el tamaño de cada array de los productores.
     *  
     */
    
    public void StartProduction() {
        
        if (begin) {
            
            this.counter = daysToDeliver;
            
            // Mutex 
            this.mutexButtonProducer = new Semaphore(1);
            this.mutexLegProducer = new Semaphore(1);       
            this.mutexArmProducer = new Semaphore(1);
            this.mutexBodyProducer = new Semaphore(1);
            this.mutexPanaProducer = new Semaphore(1);
            this.mutexBossManager = new Semaphore(1);
            
            // Semáforos de Consumo
            this.semButtonConsumer = new Semaphore(0);
            this.semLegConsumer = new Semaphore(0);
            this.semArmConsumer = new Semaphore(0);
            this.semBodyConsumer = new Semaphore(0);
            
            // Se muestran los datos actuales en la interfaz
            Interface.AmountOfButtons.setText(Integer.toString(this.ButtonStock));
            Interface.AmountOfLegs.setText(Integer.toString(this.LegStock));
            Interface.AmountOfBodies.setText(Integer.toString(this.BodyStock));
            Interface.AmountOfArms.setText(Integer.toString(this.ArmStock));
            Interface.AmountOfPana.setText(Integer.toString(this.PanaStock));
            
            Interface.BossStatus.setText(this.bossStatus);
            Interface.ManagerStatus.setText(this.managerStatus);             
            Interface.DaysLeft.setText(Integer.toString(this.daysToDeliver));
            
            // Se inicializa el jefe, gerente, productores y semáforos 
            Boss bossOfFactory = new Boss(mutexBossManager);
            bossOfFactory.start();

            Manager managerOfCompany = new Manager(mutexBossManager, mutexPanaProducer);
            managerOfCompany.start();
            
            this.semButtonProducer = new Semaphore(maxStockButtons);
            this.buttonProducers = new ButtonProducer[maxProdButtons];
            // En caso que el valor inicial sea 0, se refleja en la interfaz 
            if(initialProdButtons==0){ Interface.ButtonProducer.setText(Integer.toString(this.actualButtonProd)); }
            for (int j = 0; j < initialProdButtons; j++) {hireButtonProducer(); }  // Contrato productores
            
            this.semArmProducer = new Semaphore(maxStockArms);
            this.armProducers = new ArmProducer[maxProdArms];
            // En caso que el valor inicial sea 0, se refleja en la interfaz 
            if(initialProdArms==0){ Interface.ArmProducer.setText(Integer.toString(this.actualArmProd)); }
            for (int j = 0; j < initialProdArms; j++) {hireArmProducer();}     // Contrato productores
            
            this.semLegProducer = new Semaphore(maxStockLegs);
            this.legProducers = new LegProducer[maxProdLegs];
            // En caso que el valor inicial sea 0, se refleja en la interfaz 
            if(initialProdLegs==0){ Interface.LegProducer.setText(Integer.toString(this.actualLegProd)); }
            for (int j = 0; j < initialProdLegs; j++) { hireLegProducer(); }   // Contrato productores
            
            this.semBodyProducer = new Semaphore(maxStockBody);
            this.bodyProducers = new BodyProducer[maxProdBody];
            // En caso que el valor inicial sea 0, se refleja en la interfaz 
            if(initialProdBody==0){ Interface.BodyProducer.setText(Integer.toString(this.actualBodyProd)); }
            for (int j = 0; j < initialProdBody; j++) { hireBodyProducer(); }   // Contrato productores
            
            this.panaProducers = new Assembler[maxProdAssembler];
             // En caso que el valor inicial sea 0, se refleja en la interfaz 
            if(initialProdAssembler==0){ Interface.PanaProducer.setText(Integer.toString(this.actualPanaProd)); }
            for (int j = 0; j < initialProdAssembler; j++) {hireAssembler();}   // Contrato productores

        } else { System.exit(0); }
    }
        
    /**
     * Método para contratar productores de botones.
     * 
     * En este método se verifica si la cantidad de productores actuales de botones es menor que
     * la cantidad máxima de productores de botones. De ser así, se crea un nuevo productor,
     * se le agrega al array de productores y se inicia el thread, para finalmente aumentar la cantidad 
     * de productores contratados. 
     * 
     */
   public void hireButtonProducer(){
       
        if (this.actualButtonProd < this.maxProdButtons) {
            
            ButtonProducer newButtonprod = new ButtonProducer("prodbutton"+actualButtonProd, mutexButtonProducer, semButtonConsumer, semButtonProducer);
            this.buttonProducers[this.actualButtonProd] = newButtonprod;
            
            newButtonprod.start();
            this.actualButtonProd++;
            Interface.ButtonProducer.setText(Integer.toString(this.actualButtonProd));
            
        } else{JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad máxima de productores de botones"); }
    }
   
   /**
     * Método para contratar productores de brazos.
     * 
     * En este método se verifica si la cantidad de productores actuales de brazos es menor que
     * la cantidad máxima de productores de brazos. De ser así, se crea un nuevo productor,
     * se le agrega al array de productores y se inicia el thread, para finalmente aumentar la cantidad 
     * de productores contratados. 
     * 
     */
   
   public void hireArmProducer(){
       
        if (actualArmProd < maxProdArms) {
                       
            ArmProducer newArmprod = new ArmProducer("prodArm"+actualArmProd,mutexArmProducer,semArmConsumer,semArmProducer);
            armProducers[actualArmProd]=newArmprod;
            
            newArmprod.start();
            actualArmProd++;
            Interface.ArmProducer.setText(Integer.toString(actualArmProd));
        
        }else{ JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad máxima de productores de brazos"); }
    }
   
   /**
     * Método para contratar productores de piernas.
     * 
     * En este método se verifica si la cantidad de productores actuales de piernas es menor que
     * la cantidad máxima de productores de piernas. De ser así, se crea un nuevo productor,
     * se le agrega al array de productores y se inicia el thread, para finalmente aumentar la cantidad 
     * de productores contratados. 
     * 
     */
   public void hireLegProducer(){
       
        if (actualLegProd < maxProdLegs) {
            
            LegProducer newLegprod = new LegProducer("prodLeg"+actualLegProd, mutexLegProducer, semLegConsumer, semLegProducer);
            legProducers[actualLegProd] = newLegprod;
            
            newLegprod.start();
            actualLegProd++;
            Interface.LegProducer.setText(Integer.toString(actualLegProd));
            
        } else{ JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad máxima de productores de piernas"); }  
    }
 
   /**
     * Método para contratar productores de cuerpos.
     * 
     * En este método se verifica si la cantidad de productores actuales de cuerpos es menor que
     * la cantidad máxima de productores de cuerpos. De ser así, se crea un nuevo productor,
     * se le agrega al array de productores y se inicia el thread, para finalmente aumentar la cantidad 
     * de productores contratados. 
     * 
     */
   public void hireBodyProducer(){
       
        if (actualBodyProd < maxProdBody) {
            
            BodyProducer newBodyprod = new BodyProducer("prodBody"+actualBodyProd, mutexBodyProducer, semBodyConsumer, semBodyProducer);
            bodyProducers[actualBodyProd] = newBodyprod;

            newBodyprod.start();
            actualBodyProd++;
            Interface.BodyProducer.setText(Integer.toString(actualBodyProd));
            
        } else { JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad máxima de productores de cuerpos"); }
    }  
   
   /**
     * Método para contratar ensambladores.
     * 
     * En este método se verifica si la cantidad de ensambladores actuales es menor que
     * la cantidad máxima de productores de ensambladores. De ser así, se crea un nuevo productor,
     * se le agrega al array de ensambladores y se inicia el thread, para finalmente aumentar la cantidad 
     * de productores ensambladores. 
     * 
     */

   public void hireAssembler(){
       
        if (actualPanaProd < maxProdAssembler) {
            
            Assembler newPanaProd = new Assembler("prodPana"+actualPanaProd, this.mutexPanaProducer, 
                    this.semButtonConsumer, this.semButtonProducer, this.semArmConsumer, this.semArmProducer, this.semLegConsumer, 
                    this.semLegProducer, this.semBodyConsumer, this.semBodyProducer, this.mutexButtonProducer , this.mutexLegProducer, 
                    this.mutexArmProducer, this.mutexBodyProducer);
            
            panaProducers[actualPanaProd] = newPanaProd;
            newPanaProd.start();
            actualPanaProd++;
            Interface.PanaProducer.setText(Integer.toString(actualPanaProd));

        } else{ JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad máxima de productores de Panas"); }     
    }

   /**
     * Método para despedir productores de botones.
     * 
     * En este método, se verifica si la cantidad actual de productores de botones es mayor a 0. De ser así,
     * se disminuye la cantidad actual de productores de botones y se cambia de contratado a despedido.
     * 
     */
   public void fireButtonProducer() {
       
       if (actualButtonProd > 0) {
           actualButtonProd--;
           buttonProducers[actualButtonProd].hired=false;
           Interface.ButtonProducer.setText(Integer.toString(actualButtonProd));
           
       } else { JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad mínima de productores de botones"); }
    }

   /**
     * Método para despedir productores de brazos.
     * 
     * En este método, se verifica si la cantidad actual de productores de brazos es mayor a 0. De ser así,
     * se disminuye la cantidad actual de productores de brazos y se cambia de contratado a despedido.
     * 
     */
   
   public void fireArmProducer(){
       
       if (actualArmProd > 0) {
           actualArmProd--;
           armProducers[actualArmProd].hired=false;
           Interface.ArmProducer.setText(Integer.toString(actualArmProd));
           
       } else { JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad mínima de productores de brazos"); }
    }

   /**
     * Método para despedir productores de piernas.
     * 
     * En este método, se verifica si la cantidad actual de productores de piernas es mayor a 0. De ser así,
     * se disminuye la cantidad actual de productores de piernas y se cambia de contratado a despedido.
     * 
     */
   
   public void fireLegProducer(){
       
       if (actualLegProd > 0) {
           actualLegProd--;
           legProducers[actualLegProd].hired = false;
           Interface.LegProducer.setText(Integer.toString(actualLegProd));
           
       } else{ JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad mínima de productores de piernas"); }
    }

   /**
     * Método para despedir productores de cuerpos.
     * 
     * En este método, se verifica si la cantidad actual de productores de cuerpos es mayor a 0. De ser así,
     * se disminuye la cantidad actual de productores de cuerpos y se cambia de contratado a despedido.
     * 
     */
   
   public void fireBodyProducer(){
       
       if (actualBodyProd > 0) {
           
           actualBodyProd--;
           bodyProducers[actualBodyProd].hired = false;
           Interface.BodyProducer.setText(Integer.toString(actualBodyProd));
           
       } else { JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad mínima de productores de cuerpos"); }
    }  
   
   /**
     * Método para despedir productores de ensambladores.
     * 
     * En este método, se verifica si la cantidad actual de ensambladores es mayor a 0. De ser así,
     * se disminuye la cantidad actual de ensambladores y se cambia de contratado a despedido.
     * 
     */
   
   public void fireAssembler(){
       
        if (actualPanaProd > 0) {
            actualPanaProd--;
            panaProducers[actualPanaProd].hired = false;
            Interface.PanaProducer.setText(Integer.toString(actualPanaProd));
            
        } else { JOptionPane.showMessageDialog(null, "Se alcanzo la cantidad mínima de ensambladores"); }
    }  
}  

    

    

