// Aguarda o documento estar completamente carregado
$(document).ready(function() {
    const modal = $('#contactModal');
    const form = $('#contactForm');
    const errorContainer = $('#formError');

    // --- FUNÇÕES DE MANIPULAÇÃO DO MODAL ---

    // Abre o modal de cadastro
    $('#openModalBtn').on('click', function() {
        form[0].reset(); // Limpa o formulário
        errorContainer.hide(); // Esconde mensagens de erro
        modal.show();
    });

    // Fecha o modal ao clicar no 'X'
    $('.close-btn').on('click', function() {
        modal.hide();
    });

    // Fecha o modal ao clicar fora dele
    $(window).on('click', function(event) {
        if ($(event.target).is(modal)) {
            modal.hide();
        }
    });


    // --- LÓGICA DE SUBMISSÃO DO FORMULÁRIO ---

    form.on('submit', function(event) {
        // Previne o comportamento padrão de submissão do formulário
        event.preventDefault();

        // Coleta os dados do formulário
        const contactData = {
            nome: $('#nome').val(),
            telefone: $('#telefone').val(),
            email: $('#email').val()
        };

        // Chama a função para salvar o contato
        saveContact(contactData);
    });


    /**
     * Envia os dados do novo contato para o backend via AJAX.
     * @param {object} contactData - O objeto contendo nome, telefone e email.
     */
    function saveContact(contactData) {
        $.ajax({
            // Endpoint definido no ContactController
            url: '/contatos/form',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(contactData), // Converte o objeto JS para uma string JSON
            success: function(response) {
                modal.hide();       // Fecha o modal
                form[0].reset();    // Limpa o formulário
                loadContacts();     // Recarrega a lista de contatos para exibir o novo
                // Opcional: Adicionar uma notificação de sucesso
                alert('Contato salvo com sucesso!');
            },
            error: function(xhr, status, error) {
                console.error("Erro ao salvar contato:", xhr.responseText);
                // Exibe a mensagem de erro retornada pelo backend
                const errorMessage = xhr.responseText || "Ocorreu um erro desconhecido.";
                errorContainer.text(errorMessage);
                errorContainer.show();
            }
        });
    }


    /**
     * Função principal para carregar os contatos via AJAX.
     */
    function loadContacts() {
        $.ajax({
            url: '/contatos/list',
            type: 'GET',
            dataType: 'json',
            success: function(contacts) {
                const container = $('#contacts-container');
                container.empty();

                if (!contacts || contacts.length === 0) {
                    container.html('<p>Nenhum contato encontrado.</p>');
                    return;
                }

                contacts.forEach(function(contact) {
                    const cardHtml = `
                        <div class="contact-card">
                            <div class="card-body">
                                <h5 class="card-title">${contact.nome}</h5>
                                <p class="card-text"><i class="fas fa-phone"></i> ${contact.telefone || 'Não informado'}</p>
                                <p class="card-text"><i class="fas fa-envelope"></i> ${contact.email || 'Não informado'}</p>
                            </div>
                            <div class="card-footer">
                                <button class="btn btn-secondary btn-sm" onclick="editContact(${contact.id})"><i class="fas fa-edit"></i> Editar</button>
                                <button class="btn btn-danger btn-sm" onclick="removeContact(${contact.id})"><i class="fas fa-trash"></i> Remover</button>
                            </div>
                        </div>
                    `;
                    container.append(cardHtml);
                });
            },
            error: function(xhr, status, error) {
                console.error("Erro ao buscar contatos: ", status, error);
                $('#contacts-container').html('<p class="error-message">Não foi possível carregar os contatos.</p>');
            }
        });
    }

    // Carrega os contatos iniciais
    loadContacts();
});


// Funções de placeholder para edição e remoção
function editContact(id) {
    alert('Função para editar o contato com ID: ' + id);
}

function removeContact(id) {
    if (confirm('Tem certeza que deseja remover este contato?')) {
        alert('Removendo o contato com ID: ' + id);
    }
}

// Aguarda o documento estar completamente carregado
$(document).ready(function() {
    const modal = $('#contactModal');
    const form = $('#contactForm');
    const errorContainer = $('#formError');

    // ===== APLICAÇÃO DAS MÁSCARAS =====
    // Aplica a máscara de telefone ao campo com id="telefone"
    $('#telefone').mask('(00) 00000-0000');
    // ===================================

    $('#openModalBtn').on('click', function() {
        form[0].reset();
        errorContainer.hide();
        modal.show();
    });

});
