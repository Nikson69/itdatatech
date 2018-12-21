import {getSearchString} from "./index";

export function getContentList(routine, params) {
    let contentListUrl = '/content/getlist?' +  getSearchString(params);

    $.ajax({
        url: contentListUrl,
        dataType: 'json',
        success: function (result) {
            routine(result);
        }
    });
}

export function getContent(routine, id) {
    let contentListUrl = '/content/item/'+id;

    $.ajax({
        url: contentListUrl,
        dataType: 'json',
        success: function (result) {
            routine(result);
        }
    });
}


export function deleteContent(routine, id) {
    const url = '/content/item';
    const header = $('meta[name="_header"]').attr('content') ;
    const token = $('meta[name="_token"]').attr('content');
    let headers = {};
    headers[header] = token;
    $.ajax({
        type: "DELETE",
        url: url,
        headers: headers,
        data:JSON.stringify({id:id}),
        contentType:'application/json',
        dataType: 'text',
        success: function (result) {
            routine(result);
        }
    });
}


export function createContent(routine, content) {
    const url = '/content/item';
    const header = $('meta[name="_header"]').attr('content') ;
    const token = $('meta[name="_token"]').attr('content');
    let headers = {};
    headers[header] = token;


    $.ajax({
        type: "PUT",
        url: url,
        headers: headers,
        data: JSON.stringify(content),
        contentType:'application/json',
        dataType: 'text',
        success: function (result) {
            routine(result);
        },
        error: function(content){
            alert(JSON.stringify(content))
        }
    });
}



export function updateContent(routine, content) {
    const url = '/content/item';
    const header = $('meta[name="_header"]').attr('content') ;
    const token = $('meta[name="_token"]').attr('content');
    let headers = {};
    headers[header] = token;

    $.ajax({
        type: "PUT",
        url: url,
        headers: headers,
        data: JSON.stringify(content),
        contentType:'application/json',
        dataType: 'text',
        success: function (result) {
            routine(result);
        },
        error: function(content){
            alert(content.toString())
        }
    });
}
