/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.io.*;
/**
 *
 * @author c_hua
 */
public class AddObjectOutputStream extends ObjectOutputStream {
    public AddObjectOutputStream(OutputStream out) throws IOException{
			super(out);
	}
	protected void writeStreamHeader() throws IOException{
		this.reset();
	}
}
