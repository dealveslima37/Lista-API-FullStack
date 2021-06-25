function create() {

    if (confirm('Confirma o cadastro do item')) {
        let nome = $('#nome').val();
        let quantidade = $('#quantidade').val();

        $.ajax('http://localhost:8080/itens', {
            type: 'POST',
            data: JSON.stringify({
                nome: nome,
                quantidade: quantidade
            }),
            contentType: "application/json; charset=utf-8",
            success: function (response) {
                alert('Item cadastrado com sucesso')
                location.href = location.href
            },
        }).fail(function (xhr, status, errorThrown) {
            alert("Erro ao cadastrar o item: ");
        });
    }

}

function readAll() {

    $.ajax('http://localhost:8080/itens', {
        type: 'GET',
        success: function (response) {

            for (let i = 0; i < response.length; i++) {

                $('table tbody').append(`
                    <tr>
                        <th scope="row">${response[i].nome}</th>
                        <td>${response[i].quantidade}</td>
                        <td>${response[i].data}</td>
                        <td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal" onclick="readById('${response[i].id}')">Editar</button></td>
                        <td><button type="button" class="btn btn-danger" onclick="deleteItem('${response[i].id}')">Deletar</button></td>
                    </tr>
                `)

            }

        }
    })

}

function readById(id) {
    $.ajax(`http://localhost:8080/itens/${id}`, {
        type: 'GET',
        success: function (response) {
            $("#itemNome").val(response.nome)
            $("#itemQuantidade").val(response.quantidade)
            $("#itemId").val(response.id)
            $("#data").val(response.data)
        }
    }).fail(function (xhr, status, errorThrown) {
        alert("Não existe item cadastrado com esse id: ");
    });

}

function update() {

    if (confirm('Comfirma a atualização do item')) {
        let itemid = $("#itemId").val()
        let itemNome = $("#itemNome").val()
        let itemQuantidade = $("#itemQuantidade").val();

        $.ajax(`http://localhost:8080/itens/${itemid}`, {
            type: 'PUT',
            data: JSON.stringify({
                nome: itemNome,
                quantidade: itemQuantidade
            }),
            contentType: "application/json; charset=utf-8",
            success: function (response) {
                alert('Item Atualizado com sucesso')
                $('#exampleModal').modal('hide');
                location.href = location.href
            },
        }).fail(function (xhr, status, errorThrown) {
            alert("Erro ao atualizar o item: ");
        });
    }


}

function deleteItem(id) {

    if (confirm('Deseja delete esse item?')) {

        $.ajax(`http://localhost:8080/itens/${id}`, {
            type: 'DELETE',
            success: function (response) {
                alert('Item Deletado com sucesso')
                location.href = location.href
            },

        }).fail(function (xhr, status, errorThrown) {
            alert("Erro ao deletar o item: ");
        });

    }

}

function deleteAll() {

    if (confirm('Deseja deletar a lista?')) {

        $.ajax(`http://localhost:8080/itens`, {
            type: 'DELETE',
            success: function (response) {
                alert('Lista deletada com sucesso')
                location.href = location.href
            },

        }).fail(function (xhr, status, errorThrown) {
            alert("Erro ao deletar a lista: ");
        });

    }
}

readAll()
