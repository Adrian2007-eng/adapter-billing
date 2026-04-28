public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Facturación Electrónica ===\n");

        Cliente cliente = new Cliente("Juan Pérez", "20123456789");
        double montoPedido = 250.00;

        System.out.println("Registrando pedido para: " + cliente.getNombre());
        System.out.println("Monto: S/ " + montoPedido);
        System.out.println("Pedido validado correctamente.\n");

        FacturaService servicio = new BillingAdapter();
        servicio.emitirFactura(cliente, montoPedido);

        System.out.println();
        String estado = servicio.verificarEstado();
        System.out.println("\n[Main] Estado final de la factura: " + estado);

        if ("EXITOSO".equals(estado)) {
            System.out.println("[Main] Factura generada exitosamente para "
                    + cliente.getNombre() + " por S/ " + montoPedido);
        } else {
            System.out.println("[Main] Error al generar la factura. Revisar sistema.");
        }
    }
}
