package com.tuckersoft.branchengine.StoryNode;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
@Getter
@Setter
public class StoryNodeDto {
    private Long id;
    private String nodeCode;
    private String title;
    private String sceneText;
    private Integer branchCapacity;
    private Integer currentBranches;
    private String primaryBranchCode;
    private String glitchBranchCode;

    // Getters y setters

    }
@Getter
@Setter
public class PagedResponseDto<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;

    public PagedResponseDto(Page<T> pageResult) {
        this.content = pageResult.getContent();
        this.page = pageResult.getNumber();
    this.size = pageResult.getSize();
    this.totalElements = pageResult.getTotalElements();
}

    // Getters
}


/*public class ProductoDTO {

    // @DecimalMin / @DecimalMax: Valida el valor mínimo y máximo para tipos numéricos (incluido BigDecimal).
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser positivo")
    @DecimalMax(value = "99999.99", message = "El precio es demasiado alto")
    private BigDecimal precio;

    // @Min / @Max: Valida el valor mínimo y máximo para tipos primitivos (int, long, etc.) y sus wrappers.
    @Min(value = 1, message = "El stock mínimo es 1")
    @Max(value = 1000, message = "El stock máximo es 1000")
    private int stock;

    // 3. Validación de formato de datos (email y expresiones regulares)

    // @Email: Valida que el String tenga un formato de email válido.
    @Email(message = "El formato del email es incorrecto")
    @NotBlank(message = "El email del proveedor es obligatorio")
    private String emailProveedor;

    // @Pattern: Permite definir una Expresión Regular personalizada. (Ver ejemplos abajo)
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "El código debe tener el formato XXX-XXX-XXXX")
    private String codigoProducto;

    // 4. Validación de fechas

    // @Past / @Future: Valida que un campo de fecha sea en el pasado o en el futuro.
    @Past(message = "La fecha de fabricación debe ser una fecha pasada")
    private java.time.LocalDate fechaFabricacion;

    // (Getters y Setters)
}*/



