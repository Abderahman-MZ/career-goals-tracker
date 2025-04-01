// Fetch and display users
async function loadUsers() {
  const response = await fetch("/users");
  const users = await response.json();
  const list = document.getElementById("users-list");
  list.innerHTML = "";
  users.forEach((user) => {
    const li = document.createElement("li");
    li.textContent = `${user.name} (${user.email})`;
    list.appendChild(li);
  });
}

// Fetch and display objectives
async function loadObjectives() {
  const response = await fetch("/objectives");
  const objectives = await response.json();
  const list = document.getElementById("objectives-list");
  list.innerHTML = "";
  objectives.forEach((obj) => {
    const li = document.createElement("li");
    li.textContent = `${obj.title} - ${obj.description} (Progress: ${obj.progress}%)`;
    list.appendChild(li);
  });
}

// Fetch and display skills
async function loadSkills() {
  const response = await fetch("/skills");
  const skills = await response.json();
  const list = document.getElementById("skills-list");
  list.innerHTML = "";
  skills.forEach((skill) => {
    const li = document.createElement("li");
    li.textContent = `${skill.name} - ${
      skill.completed ? "Completed" : "Not Completed"
    }`;
    list.appendChild(li);
  });
}

// Add user
document.getElementById("user-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  const name = document.getElementById("user-name").value;
  const email = document.getElementById("user-email").value;
  await fetch("/users", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, email }),
  });
  loadUsers();
  e.target.reset();
});

// Add objective
document
  .getElementById("objective-form")
  .addEventListener("submit", async (e) => {
    e.preventDefault();
    const title = document.getElementById("objective-title").value;
    const description = document.getElementById("objective-desc").value;
    await fetch("/objectives", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, description, progress: 0 }),
    });
    loadObjectives();
    e.target.reset();
  });

// Add skill
document.getElementById("skill-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  const name = document.getElementById("skill-name").value;
  const completed = document.getElementById("skill-completed").checked;
  await fetch("/skills", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, completed }),
  });
  loadSkills();
  e.target.reset();
});

// Initial load
loadUsers();
loadObjectives();
loadSkills();
