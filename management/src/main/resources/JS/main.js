
document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('employeeForm');
  if (!form) return;

  form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const designation = document.getElementById("designation").value;
    const joiningDate = document.getElementById("joiningDate").value;
    const departmentId = document.getElementById("departmentId").value;
    const roleId = document.getElementById("roleId").value;
    const fileInput = document.getElementById("resume");

    if (!fileInput.files.length) {
      alert("Please select a resume file.");
      return;
    }

    const employee = {
      name,
      email,
      phone,
      designation,
      joiningDate,
      department: { id: parseInt(departmentId) },
      role: { id: parseInt(roleId) }
    };

    try {
      const createRes = await fetch("/api/employees", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
      });

      const createdEmployee = await createRes.json();
      const employeeId = createdEmployee.id;

      if (!employeeId) {
        alert("Employee creation failed or no ID returned.");
        return;
      }

      const formData = new FormData();
      formData.append("file", fileInput.files[0]);

      const uploadRes = await fetch(`/api/employees/${employeeId}/upload-resume`, {
        method: "POST",
        body: formData
      });

      const message = await uploadRes.text();
      alert("✅ " + message);
    } catch (err) {
      alert("❌ Error: " + err.message);
    }
  });
});
