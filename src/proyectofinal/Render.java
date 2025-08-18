/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jhesi Colque
 */
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JButton) {
            JButton button = (JButton) value;
            return button;
        }
        return this;
    }
}