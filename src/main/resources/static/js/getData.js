function loadData(url, data, callback,error) {
    fetch(url, {
        // mode: 'cors',
        method: 'POST',
        body: data//,
        // headers: {
            // 'Content-Type': 'application/json'
            //     'Origin': 'http://localhost:3000'       
        // }
    }).
    then(result => {
        if (result.status != 200) {
            // if (!result.ok) {
            throw Error(result.statusText);
        } else {
            return result.json();
        }
    }).then(callback).catch(error);
}