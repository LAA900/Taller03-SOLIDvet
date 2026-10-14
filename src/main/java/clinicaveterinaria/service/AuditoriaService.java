
package clinicaveterinaria.service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aleja
 */
public class AuditoriaService {

    private final Map<String, Integer> auditoria = new HashMap<>();

    public void registrarOperacion(String nombre) {
        auditoria.put(nombre, auditoria.getOrDefault(nombre, 0) + 1);
    }

    public Map<String, Integer> getAuditoria() {
        return new HashMap<>(auditoria);
    }
}
