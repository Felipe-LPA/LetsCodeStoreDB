package com.letscode.store.dto;

import com.letscode.store.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    private String name;
    private String cpf;

    public static ClientDTO convert(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setCpf(client.getCpf());
        return dto;
    }
}
