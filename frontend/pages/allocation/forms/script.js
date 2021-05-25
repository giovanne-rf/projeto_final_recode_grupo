const apiUrl = "http://localhost:8080/allocations";
const apiUrlProfessor = "http://localhost:8080/professors";
const apiUrlCourse = "http://localhost:8080/courses";

const form = document.querySelector("form");

let id = 0;

const verifyId = () => {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    id = urlParams.get('id');

    if(id) {
      const title = document.getElementById("title-form");
      title.innerText = "Edit Allocation";
      getData(id);
    }
};

const getData = async (id) => {
  const response = await fetch(apiUrl + `/${id}`);
  if(response.ok) {
    const data = await response.json();
    document.getElementById("day").value = data.days;
    document.getElementById("start").value = data.start_hour;
    document.getElementById("end").value = data.end_hour;
    loadSelect();
  }
};

const loadSelect = async () => {
  const professor = document.getElementById("professor");
  const course = document.getElementById("course");
  const responseProfessor = await fetch(apiUrlProfessor);
  const responseCourse = await fetch(apiUrlCourse);
  if (responseProfessor.ok || responseCourse.ok) {
    const dataProfessor = await responseProfessor.json();
    const dataCourse = await responseCourse.json();
    for (let i = 0; i < dataProfessor.length; i++) {
      professor.innerHTML += `
      <option value="${dataProfessor[i].id}">${dataProfessor[i].name}</option>
      `;
    }
    for (let i = 0; i < dataCourse.length; i++) {
      course.innerHTML += `
      <option value="${dataCourse[i].id}">${dataCourse[i].name}</option>
      `;
    }
    
  }
};

verifyId(); 
loadSelect();

//começa aqui

const daysOfWeek = [];
const loadDaysOfWeek = () => {
  daysOfWeek.push("Sunday");
  daysOfWeek.push("Monday");
  daysOfWeek.push("Tuesday");
  daysOfWeek.push("Wednesday");
  daysOfWeek.push("Thursday");
  daysOfWeek.push("Friday");
  daysOfWeek.push("Saturday");

  const optionsDays = daysOfWeek.map(day => {
    return `<option value="${day.toUpperCase()}">${day}</option>`
  });

  document.getElementById("day").innerHTML = optionsDays;
}

const loadHours = () => {
  const hours = [...Array(24).keys()]

  const optionsHours = hours.map(hour => {
    return `<option value="${hour}">${hour}</option>`
  });

  document.getElementById("start").innerHTML = optionsHours;
  document.getElementById("end").innerHTML = optionsHours;
}

loadDaysOfWeek();
loadHours();
//termina aqui
  
const save = (e) => {
  e.preventDefault();

  const professorId = parseInt(document.getElementById("professor").value);
  const courseId = parseInt(document.getElementById("course").value);
  const dayOfWeek = document.getElementById("day").value.trim();
  const startHour = parseInt(document.getElementById("start").value.trim());
  const endHour = parseInt(document.getElementById("end").value);

  if (!professorId || !courseId || !dayOfWeek || !startHour || !endHour) {
    alert("All inputs are necessary!");
    return;
  }

  const method = id ? "PUT" : "POST";
  let url = apiUrl;
  if (id) {
    url = apiUrl + `/${id}`;
  }

  const objRequest = {
    days: dayOfWeek,
    start_hour: startHour,
    end_hour: endHour,
    professor: {
      id: professorId
    },
    course: {
      id: courseId
    }
  };

  makeRequest(objRequest, method, url);
}

form.addEventListener("submit", save);

async function makeRequest(data, method, url) {
  const res = await fetch(url, {
    method: method,
    headers: {
      'Accept': 'application/json',
      'Content-Type':'application/json'
    },
    body: JSON.stringify(data)
  });

  if(!res.ok) {
    alert(`${res.status} - ${res.statusText}`);
    return;
  }

  const jsonResult = await res.json();
  if(JSON.stringify(jsonResult).includes("message")) {
    alert(jsonResult.message);
  }else {
    location.href = '../';
  }
};

document.getElementById("cancel").addEventListener("click", () => {
  location.href = '../';
});
