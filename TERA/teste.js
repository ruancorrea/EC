class Livro{
    constructor(nome,autor,genero){
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
    }
}

var livros = [];
livros[0] = new Livro('Joaozinho e Tomé', 'Pedrinho', 'Fedoso');
livros[1] = new Livro('Tomé', 'Ivan', 'Fedoso');
livros[2] = new Livro('Joaozinho', 'Felismino', 'Corrupto');
livros[3] = new Livro('Tom é bom', 'Felismino', 'Corrupto');
livros[4] = new Livro('Pi', 'Hiaguh', 'Claudioso');
livros[5] = new Livro('Fisica Quantica', 'Fidelis', 'Skate');
livros[6] = new Livro('O guarda e a chuva', 'Fidelis', 'Skate');


function listItems(items, pageActual, limitItems){
    let result = [];
    let totalPage = Math.ceil( items.length / limitItems );
    let count = ( pageActual * limitItems ) - limitItems;
    let delimiter = count + limitItems;

    if(pageActual <= totalPage){
        for(let i=count; i<delimiter; i++){
            if(items[i] != null){
                result.push(items[i]);
            }
            count++;
        }
    }
return result;
}

/*var next = ['Next 1','Next 2 ','Next 3','Next 4 ','Next 5', 'Next 6 '];
var resultNext = listItems(next, 1, 2);
var resultNext2 = listItems(next, 2, 2);
var resultNext3 = listItems(next, 3, 2);
*/

var alo = [];
for(i = 0;i<3;i++)
{
    alo[i] = document.getElementById("tab" + i);
}

var aloalo = [];
aloalo[0] = alo;

console.log(aloalo);



/*YEAH*/ 
var tamanhoPagina = 4;
var pagina = 0;
var table = [];

for(var k = 0; k < livros.length;k++){
    table[k] = "<table id = 'tabelinha'><thead><tr><td>Livro</td>" + "<td>" + livros[k].nome;
    table[k] +="<tr><td>Autor</td>" + "<td>" + livros[k].autor;
    table[k] +="<tr><td>Gênero</td>" + "<td>" + livros[k].genero + "</thead><tbody>";
    table[k] += "</tbody</table>";
}


function paginar() {
    $('table > tbody > tr').remove();
    var tbody = $('table > tbody');
    var output = document.getElementById("output");
    for (var i = pagina * tamanhoPagina; i < livros.length && i < (pagina + 1) *  tamanhoPagina; i++) {
        tbody.append(
            $('<tr>')
                .append($('<td>').append(table[i]))
        )   
    }
    $('#numeracao').text('Página ' + (pagina + 1) + ' de ' + Math.ceil(livros.length / tamanhoPagina));
}

function ajustarBotoes() {
    $('#proximo').prop('disabled', livros.length <= tamanhoPagina || pagina > livros.length / tamanhoPagina - 1);
    $('#anterior').prop('disabled', livros.length <= tamanhoPagina || pagina == 0);
}

$(function() {
    $('#proximo').click(function() {
        if (pagina < livros.length / tamanhoPagina - 1) {
            pagina++;
            paginar();
            ajustarBotoes();
        }
    });
    $('#anterior').click(function() {
        if (pagina > 0) {
            pagina--;
            paginar();
            ajustarBotoes();
        }
    });
    paginar();
    ajustarBotoes();
});