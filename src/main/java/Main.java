import java.util.Scanner;

/**
 * Cliente (Client) del patrón Adapter.
 * Solicita los datos al usuario por consola antes de emitir la factura.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Facturación Electrónica ===\n");

        // --- Solicitar datos al usuario ---
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el RUC del cliente: ");
        String ruc = scanner.nextLine();

        System.out.print("Ingrese el monto del pedido (S/): ");
        double monto = Double.parseDouble(scanner.nextLine());

        System.out.println("\nPedido validado correctamente.\n");

        // --- Historia de Usuario 1: Emitir factura ---
        Cliente cliente = new Cliente(nombre, ruc);
        FacturaService servicio = new BillingAdapter();
        servicio.emitirFactura(cliente, monto);

        // --- Historia de Usuario 2: Confirmar estado ---
        System.out.println();
        String estado = servicio.verificarEstado();
        System.out.println("\n[Main] Estado final de la factura: " + estado);

        if ("EXITOSO".equals(estado)) {
            System.out.println("[Main] Factura generada exitosamente para "
                    + cliente.getNombre() + " por S/ " + monto);
        } else {
            System.out.println("[Main] Error al generar la factura. Revisar sistema.");
        }

        scanner.close();
    }
}
