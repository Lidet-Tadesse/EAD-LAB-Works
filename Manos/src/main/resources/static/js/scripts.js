document.addEventListener("DOMContentLoaded", function () {
    // Simulated donation history for donors
    const donationHistory = [
        { type: "Money", amount: "$100", category: "Education", date: "2025-01-20" },
        { type: "Clothes", amount: "5 bags", category: "General", date: "2025-01-15" },
        { type: "Food", amount: "10 meals", category: "Health", date: "2025-01-10" }
    ];

    const peopleHelped = 15; // Example data

    // Populate Donor Dashboard
    if (document.getElementById("donation-history")) {
        let tableBody = document.getElementById("donation-history");
        donationHistory.forEach(donation => {
            let row = document.createElement("tr");
            row.innerHTML = `<td>${donation.type}</td><td>${donation.amount}</td><td>${donation.category}</td><td>${donation.date}</td>`;
            tableBody.appendChild(row);
        });
        document.getElementById("total-donations").textContent = donationHistory.length;
        document.getElementById("people-helped").textContent = peopleHelped;
    }

    // Simulated donation requests for recipients
    const requestHistory = [
        { type: "Food", quantity: "20 meals", category: "Health", status: "Approved", date: "2025-01-18" },
        { type: "Shelter", quantity: "1 month rent", category: "Housing", status: "Pending", date: "2025-01-12" }
    ];

    // Populate Recipient Dashboard
    if (document.getElementById("request-history")) {
        let tableBody = document.getElementById("request-history");
        requestHistory.forEach(request => {
            let row = document.createElement("tr");
            row.innerHTML = `<td>${request.type}</td><td>${request.quantity}</td><td>${request.category}</td><td>${request.status}</td><td>${request.date}</td>`;
            tableBody.appendChild(row);
        });
    }
});
