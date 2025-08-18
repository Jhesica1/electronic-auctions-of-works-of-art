package proyectofinal;
import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class ArchPujas {
    private String archivoPujas = "pujas.dat";
    private ArchObras archObras;
    
    public ArchPujas(ArchObras archObras) {
        this.archObras = archObras;
    }
    
    public String obtenerPujasComoString(String correoObra) throws IOException, ClassNotFoundException {
    StringBuilder sb = new StringBuilder();

    FileInputStream fosObra = new FileInputStream("archivoObras.dat");
    ObjectInputStream oisObra = new ObjectInputStream(fosObra);

    boolean obraEncontrada = false;
    try {
        while (true) {
            Obra obra = (Obra) oisObra.readObject();
            if (obra.getCorreo().equalsIgnoreCase(correoObra)) {
                sb.append("AutorObra: ").append(obra.getAutor()).append("\n");
                sb.append("CorreoObra: ").append(obra.getCorreo()).append("\n");
                sb.append("DetalleObra: ").append(obra.getDetalle()).append("\n");
                obraEncontrada = true;
                break; 
            }
        }
    } catch (EOFException e) {
      
    } finally {
        oisObra.close();
    }

    if (!obraEncontrada) {
        return "No se encontró ninguna obra con el correo: " + correoObra;
    }

    FileInputStream fisPuja = new FileInputStream("pujas.dat");
    ObjectInputStream oisPuja = new ObjectInputStream(fisPuja);

    int contador = 1;
    try {
        while (true) {
            Puja p = (Puja) oisPuja.readObject();
            if (p.getCorreoComprador().equalsIgnoreCase(correoObra)) {
                sb.append("\n[Puja").append(contador).append("]\n");
                sb.append("TipoPago: ").append(p.getTipoPago()).append("\n");
                sb.append("MontoPuja: ").append(p.getMonto()).append("\n");
                sb.append("NombreComprador: ").append(p.getNombreComprador()).append("\n");
                sb.append("ApellidoComprador: ").append(p.getApellidoComprador()).append("\n");

                contador++;
            }
        }
    } catch (EOFException e) {
    } finally {
        oisPuja.close();
    }

    if (contador == 1) {
        sb.append("\nNo hay pujas registradas para esta obra.\n");
    }

    return sb.toString();
}


private boolean existeObra(String correo) throws IOException, ClassNotFoundException {
    AtomicBoolean existe = new AtomicBoolean(false);
    archObras.buscarObra(correo, o -> existe.set(true));
    return existe.get();
}
   
public void agregarPuja(String correoObra, Puja nuevaPuja) throws IOException {
    File archivo = new File("pujas.dat");
    ObjectOutputStream out;

    // Establecer el correo de la obra en la puja (enlazarlas)
    nuevaPuja.setCorreoComprador(correoObra);

    if (archivo.exists()) {
        out = new AppendableObjectOutputStream(new FileOutputStream(archivo, true));
    } else {
        out = new ObjectOutputStream(new FileOutputStream(archivo));
    }

    out.writeObject(nuevaPuja);
    out.close();
}

    
    // Clase interna para registro de pujas
    private static class PujaRegistro implements Serializable {
        private String correoObra;
        private Puja puja;
        
        public PujaRegistro(String correoObra, Puja puja) {
            this.correoObra = correoObra;
            this.puja = puja;
        }
        
        public String getCorreoObra() { return correoObra; }
        public Puja getPuja() { return puja; }
    }
    
    // Clase para escritura appendable
    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        
        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
    
    // Método para actualizar contador (alternativa sin arrays)
    private void actualizarContadorPujas(String correoObra) throws IOException, ClassNotFoundException {
        File tempFile = new File("temp_obras.dat");
        boolean encontrada = false;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archObras.getNom()));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            
            while (true) {
                try {
                    Obra obra = (Obra) ois.readObject();
                    if (obra.getCorreo().equalsIgnoreCase(correoObra)) {
                        // Incrementar contador (asumiendo que Obra tiene un campo contadorPujas)
                        obra.setContadorPujas(obra.getContadorPujas() + 1);
                        encontrada = true;
                    }
                    oos.writeObject(obra);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        
        if (encontrada) {
            // Reemplazar archivo original
            File original = new File(archObras.getNom());
            if (original.delete()) {
                tempFile.renameTo(original);
            }
        } else {
            tempFile.delete();
        }
    }
}