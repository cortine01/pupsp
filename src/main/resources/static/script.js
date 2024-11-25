// Login/Register form
// Author: Ian Pirro 
//------------------------------------
// Form will change from login to register and visa-versa based
// on if the user is already "registered"
// "Usernames" min-len is 5 chars
//
// Could be annoying... but fun anyways


// These users "already exist"
var users = [
    { name: 'ianpirro' },
    { name: 'joeschmoe' },
    { name: 'superdev' }
    ]
    
    var loginform = {
      
      init: function() {
        this.bindUserBox();
      },
      
      bindUserBox: function() {
        var result = {};
        
        $(".form").delegate("input[name='un']", 'blur',  function(){
          var $self = $(this);
          
          // this grep would be replaced by $.post tp check db for user
          result = $.grep(users, function(elem, i){  
            return (elem.name == $self.val());
          });
          
          // This would be callback
          if (result.length === 1) {
            if( $("div.login-wrap").hasClass('register')) {
              loginform.revertForm();
              return;
            }
            else{
              return;
            }
          }
          
          if( !$("div.login-wrap").hasClass('register') ) {
            if ( $("input[name='un']").val().length > 4 )
              loginform.switchForm();
          }
    
        });
      },
      switchForm: function() {
        var $html = $("div.login-wrap").addClass('register');
        $html.children('h2').html('Register');
        $html.find(".form input[name='pw']").after("<input type='password' placeholder='Re-type password' name='rpw' />");
        $html.find('button').html('Sign up');
        $html.find('a p').html('Have an account? Sign in');
      },
      revertForm: function() {
        var $html = $("div.login-wrap").removeClass('register');
        $html.children('h2').html('Login');
        $html.find(".form input[name='rpw']").remove();
        $html.find('button').html('Sign in');
        $html.find('a p').html("Don't have an account? Register");
      },
      submitForm: function(){
        // ajax to handle register or login
      }
      
    } // loginform {}
    
    
    // Init login form
    loginform.init();
    
    
    // vertical align box   
    (function(elem){ 
        elem.css("margin-top", Math.floor( ( $(window).height() / 2 ) - ( elem.height() / 2 ) ) );
    }($(".login-wrap")));
    
    $(window).resize(function(){
        $(".login-wrap").css("margin-top", Math.floor( ( $(window).height() / 2 ) - ( $(".login-wrap").height() / 2 ) ) );
      
    });
    

      //Sidebar
      // Datos de recibos pagados de ejemplo
const recibosPagados = [
  {
      prestadora: "AguasKpital",
      periodo: "8 de Agosto - 9 de Septiembre 2024",
      fechaPago: "18 de septiembre de 2024",
      valor: "150.234",
      estado: "Pagado"
  },
  {
      prestadora: "Cens",
      periodo: "10 de Julio - 9 de Agosto 2024",
      fechaPago: "20 de agosto de 2024",
      valor: "267.342",
      estado: "Pagado"
  },
  {
      prestadora: "Gases del Oriente",
      periodo: "15 de Julio - 1 de Agosto 2024",
      fechaPago: "9 de agosto de 2024",
      valor: "67.893",
      estado: "Pagado"
  }
];

// Función para cargar los recibos pagados en la tabla
function cargarRecibos() {
  const historicoBody = document.getElementById('historico-body');
  historicoBody.innerHTML = ''; // Limpiar cualquier contenido existente

  recibosPagados.forEach(recibo => {
      const row = document.createElement('tr');
      row.innerHTML = `
          <td>${recibo.prestadora}</td>
          <td>${recibo.periodo}</td>
          <td>${recibo.fechaPago}</td>
          <td><strong>${recibo.valor}</strong></td>
          <td class="pay-button">${recibo.estado}</td>
      `;
      historicoBody.insertBefore(row, historicoBody.firstChild); // Añadir al inicio de la tabla
  });
}

// Mostrar el menú lateral
function toggleSidebar() {
  const sidebar = document.getElementById('sidebar');
  sidebar.classList.toggle('sidebar-open');
}

// Función para cerrar sesión
function logout() {
  // Lógica para cerrar sesión (redirigir o limpiar datos de sesión)
  alert("Sesión cerrada");
}

// Cargar los recibos al cargar la página
window.onload = cargarRecibos;

document.querySelectorAll('.menu-button').forEach(button => {
  button.addEventListener('click', (event) => {
      // Ocultar cualquier menú abierto
      document.querySelectorAll('.dropdown-menu').forEach(menu => {
          if (menu !== button.nextElementSibling) {
              menu.style.display = 'none';
          }
      });
    })});

// Seleccionar todos los botones de menú
const menuButtons = document.querySelectorAll('.menu-button');

// Añadir un event listener a cada botón
menuButtons.forEach(button => {
    button.addEventListener('click', (e) => {
        // Evitar que se propaguen otros clics
        e.stopPropagation();

        // Obtener el menú desplegable asociado al botón
        const dropdown = button.nextElementSibling;

        // Alternar la visibilidad del menú desplegable
        dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';

        // Cerrar cualquier otro menú desplegable
        document.querySelectorAll('.dropdown-menu').forEach(menu => {
            if (menu !== dropdown) {
                menu.style.display = 'none';
            }
        });
    });
});

// Cerrar los menús si se hace clic fuera
document.addEventListener('click', () => {
    document.querySelectorAll('.dropdown-menu').forEach(menu => {
        menu.style.display = 'none';
    });
});

//Codigo Formulario de agregar direccion
document.getElementById('addressForm').addEventListener('submit', function (e) {
  e.preventDefault(); // Evita el envío del formulario

  // Obtener valores del formulario
  const ciudad = document.getElementById('ciudad').value;
  const barrio = document.getElementById('barrio').value;
  const tipoCalle = document.getElementById('tipoCalle').value;
  const calle = document.getElementById('calle').value;
  const numeroCalle1 = document.getElementById('numeroCalle1').value;
  const numeroCalle2 = document.getElementById('numeroCalle2').value;
  const tipoDireccion = document.querySelector('input[name="tipoDireccion"]:checked').value;
  console.log(tipoDireccion);
  // Crear la cadena
  const direccion = `[${tipoCalle} ${calle} #${numeroCalle1}-${numeroCalle2} ${barrio} ${ciudad} (${tipoDireccion})]`;

  // Mostrar la cadena y redirigir
  alert(`Dirección agregada: ${direccion}`);
  window.location.href = 'addresses.html';
})
