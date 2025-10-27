// Elements
const toggleThemeBtn = document.querySelector('.header__theme-button');

document.onload = setInitialTheme(localStorage.getItem('theme'));
function setInitialTheme(themeKey) {
    if(themeKey == 'dark'){
        document.documentElement.classList.add('darkTheme');
    }else{
        document.documentElement.classList.remove('darkTheme');
    }
}

// Toggle theme button
toggleThemeBtn.addEventListener('click', () => {
    // Toggle root class
    document.documentElement.classList.toggle('darkTheme');

    if(document.documentElement.classList.contains('darkTheme')){
        localStorage.setItem('theme', 'dark');
    }else{
        localStorage.setItem('theme','light');
    }
})

