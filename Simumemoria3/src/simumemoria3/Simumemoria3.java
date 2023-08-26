/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simumemoria3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Collections;

/**
 *
 * @author Uziel
 */
public class Simumemoria3 {

    /**
     * @param args the command line arguments
     */
    public static void ordenarParticionesPorTamaño(List<Particion> particiones) {
    Collections.sort(particiones, (p1, p2) -> p1.tamano - p2.tamano);
}
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        Scanner entrada= new Scanner (System.in);
        int memoriaTotal=1000;
        List<Particion> particiones=new ArrayList<>();
        List<Proceso> procesos =new ArrayList<>();
        int cantipar;
        int cantiproc;
        int cantisobrante=0;
        int part;
        int tam;
        int tamproc;
            particiones.add(new Particion(1,100));
            procesos.add(new Proceso("Windows",100));

        System.out.print("Digite el numero de particiones: ");
        cantipar=entrada.nextInt();
        for (int i=0;i<cantipar;i++){
            System.out.print("Digite el tamano: ");
            tam=entrada.nextInt();
                    particiones.add(new Particion(i+2,tam));

        }
            ordenarParticionesPorTamaño(particiones);

        System.out.print("Digite el numero de procesos: ");
        cantiproc=entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < cantiproc; i++) {
        System.out.print("Digite el nombre: ");
        String nombreproc = entrada.nextLine();
    
         System.out.print("Digite el tamano: ");
        tamproc = entrada.nextInt();

        // Consumir el carácter de nueva línea
        entrada.nextLine();
    
         procesos.add(new Proceso(nombreproc, tamproc));
}

 int ultimaParticion = 0; 
for(int i=0;i<procesos.size();i++){
            Proceso proceso=procesos.get(i); //primera iteracion y se asigna proceso
            boolean asignado=false;         //Para saber si ese proceso esta asignado
            
            for(int j=0;j<particiones.size();j++){
                Particion particion=particiones.get(j); //Posicion
                    
                //Un booleano para insertar el tamaño para saber si entra o no
                //Primero se checa procesos y se va comparando espacios para ver si entra o no
                if(!particion.ocupada && particion.tamano>=proceso.tamano){
                    particion.ocupada=true;
                    particion.nombreProceso=proceso.nombre;
                    asignado=true;
                                    cantisobrante=cantisobrante+(particion.tamano-proceso.tamano);
                    memoriaTotal=memoriaTotal-particion.tamano;
                    System.out.println(proceso.nombre+" asignado a la particion "+particion.id);
                    break;
                }
            }
            if(!asignado){
                System.out.println(proceso.nombre+" No fue asignado a memoria");
            }
        }

        System.out.println("El sistema operativo ocupa 100 de espacio");
        System.out.println("El espacio de memoria sobrante si se considera las particiones:"+memoriaTotal);
        if(cantisobrante!=0){
                 particiones.add(new Particion(cantipar+2,cantisobrante+memoriaTotal));
         System.out.println("Se creo la particion "+(cantipar+2)+" con el tamano sobrante de "+(cantisobrante+memoriaTotal));
        }
    }
    
}
