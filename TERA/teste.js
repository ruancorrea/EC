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