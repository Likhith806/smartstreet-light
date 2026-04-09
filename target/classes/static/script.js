let chart;

// Add Light
function addLight() {
    fetch("/api/light/add", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            status: "ON",
            lightLevel: Math.floor(Math.random() * 100)
        })
    })
    .then(() => loadLights());
}

// Load Data + Chart
function loadLights() {
    fetch("/api/light/all")
    .then(res => res.json())
    .then(data => {

        let list = document.getElementById("list");
        list.innerHTML = "";

        let total = data.length;
        let sum = 0;

        let labels = [];
        let brightnessData = [];

        data.forEach(light => {

            sum += light.brightness;

            let statusClass = light.status === "ON" ? "on" : "off";

            let item = document.createElement("li");

            item.innerHTML = `
                <span>
                    💡 <b class="${statusClass}">${light.status}</b> |
                    🔆 ${light.brightness} |
                    🌙 ${light.lightLevel}
                </span>

                <button onclick="toggleLight(${light.id})">
                    Toggle
                </button>
            `;

            list.appendChild(item);

            // Chart Data
            labels.push("Light " + light.id);
            brightnessData.push(light.brightness);
        });

        // Stats
        document.getElementById("total").innerText = total;
        document.getElementById("avg").innerText =
            total === 0 ? 0 : Math.round(sum / total);

        // Chart
        if (chart) chart.destroy();

        let ctx = document.getElementById("chart").getContext("2d");

        chart = new Chart(ctx, {
            type: "bar",
            data: {
                labels: labels,
                datasets: [{
                    label: "Brightness",
                    data: brightnessData
                }]
            }
        });

    });
}

// Refresh
function refreshLights() {
    loadLights();
}

// Toggle
function toggleLight(id) {
    fetch(`/api/light/toggle/${id}`, {
        method: "PUT"
    })
    .then(() => loadLights());
}

// Clear
function clearAll() {
    if(confirm("Delete all lights?")) {
        fetch("/api/light/clear", {
            method: "DELETE"
        })
        .then(() => loadLights());
    }
}

// 🔐 Logout
function logout() {
    localStorage.removeItem("loggedIn");
    window.location.href = "login.html";
}

// Auto Load
window.onload = loadLights;