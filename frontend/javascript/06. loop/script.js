// For
for(let i=0; i<10; i++){
    if(i===3){
        console.log('It is 3');
        continue;
    }

    if(i===5){
        console.log('5 Stop the loop');
        break;
    }

    console.log('Number ' + i);
}

// For In
const user = {
    name: 'Han',
    province: '경기도',
    city: '성남시'
}

for (let x in user) {
    console.log(`${x} : ${user[x]}`);
}

// While
let i = 0;

while (i<10){
    console.log('Number ' + i);
    i++;
}

// do While
i = 0;
do {
    console.log('Number ' + i);
    i++;
}
while(i < 10)

// loop through array
const locations = ['서울', '부산', '경기도', '대구'];

// For
for(let i = 0; i< locations.length; i++){
    console.log(locations[i]);
}

// Foreach 
// break, continue 사용 X, await X
locations.forEach(function (location, index, array) {
    console.log(`${index} : ${location}`);
    console.log(array);
});

locations.map(function (location){
    console.log(location);
});

[1,2,3].forEach(num => {console.log(num)});


