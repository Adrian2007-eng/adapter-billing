public class LegacyBillingSystem {

    public void generarDocumento(String nombreCliente, double montoTotal) {
        System.out.println("[LegacyBillingSystem] Generando documento para: "
                + nombreCliente + " | Monto: S/ " + montoTotal);
    }

    public String obtenerCodigoRespuesta() {
        System.out.println("[LegacyBillingSystem] Consultando código de respuesta...");
        return "200-OK-LEGACY";
    }
}
