
document.getElementById("burger").onclick = function(){
    openCloseMenu()
};

function openCloseMenu() {
    document.getElementById("menu").classList.toggle("open")
};






document.getElementById("submit").onclick = function(){
    orderIsAccepted()
};
function orderIsAccepted() {
    alert("Ваш заказ принят!");
}
