function loadData(url, data, callback) {
    fetch(url, {
        mode: 'cors',
        method: 'POST',
        body: data,
        headers: {
            'Origin': 'http://localhost:3000'       
        }
    }).
    then(result => {
        if(!result.ok){
            throw Error(result.status);
        }
        return result.json()                
    }).then(callback).catch(console.log);
}

