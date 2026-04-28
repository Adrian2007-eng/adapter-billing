public class BillingAdapter implements FacturaService {

    private LegacyBillingSystem legacy;

    public BillingAdapter() {
        this.legacy = new LegacyBillingSystem();
    }

    @Override
    public void emitirFactura(Cliente cliente, double monto) {
        System.out.println("[BillingAdapter] Adaptando llamada a sistema legado...");
        legacy.generarDocumento(cliente.getNombre(), monto);
        System.out.println("[BillingAdapter] Factura emitida correctamente para: "
                + cliente.getNombre() + " (RUC: " + cliente.getRuc() + ")");
    }

    @Override
    public String verificarEstado() {
        System.out.println("[BillingAdapter] Verificando estado con sistema legado...");
        String codigoLegacy = legacy.obtenerCodigoRespuesta();
        return codigoLegacy.startsWith("200") ? "EXITOSO" : "ERROR: " + codigoLegacy;
    }
}
