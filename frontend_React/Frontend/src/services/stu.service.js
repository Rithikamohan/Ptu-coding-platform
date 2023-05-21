import axios from "axios";

const BASE_API_URL = "http://localhost:8080/rest/user";

class EmpService {

   async getAllEmp() {
        return axios.get(BASE_API_URL + "/students", {}, {headers:{"Authorization": "Bearer" }})
    }
    getEmpById(id) {
        return axios.get(BASE_API_URL + "/student/" + id);
    }
    findByname(name) {
        return axios.get(BASE_API_URL + "/faculty/" + name);
    }
    getallstuname() {
        return axios.get(BASE_API_URL + "/all");
    }

    getallstupoints() {
        return axios.get(BASE_API_URL + "/allpoints");
    }

    deleteEmp(id) {
        return axios.get(BASE_API_URL + "/delete/" + id);
    }

    updateEmp(id, emp) {
        return axios.post(BASE_API_URL + "/stuupdate/" + id, emp);
    }
    getMark(id) {
        return axios.get(BASE_API_URL + "/mark?name=" + id);
    }

    setMark(mark,id) {
        return axios.get(BASE_API_URL + "/points?mark= " + mark+"&name="+id);
    }
//c mark
    setC(mark,id) {
        return axios.get(BASE_API_URL + "/c?mark= " + mark+"&name="+id);
    }
    getC(id) {
        return axios.get(BASE_API_URL + "/cmark?name=" + id);
    }

    //cbasic mark
    setCbasic(mark,id) {
        return axios.get(BASE_API_URL + "/cbasic?mark= " + mark+"&name="+id);
    }
    getCbasic(id) {
        return axios.get(BASE_API_URL + "/cmarkbasic?name=" + id);
    }

    //cinter mark
    setCinter(mark,id) {
        return axios.get(BASE_API_URL + "/cinter?mark= " + mark+"&name="+id);
    }
    getCinter(id) {
        return axios.get(BASE_API_URL + "/cmarkinter?name=" + id);
    }



//cplus mark

setCplus(mark,id) {
    return axios.get(BASE_API_URL + "/cplus?mark= " + mark+"&name="+id);
}
getCplus(id) {
    return axios.get(BASE_API_URL + "/cplusmark?name=" + id);
}


    getcount(){
        return axios.get(BASE_API_URL + "/totalstu");
    }
}

export default new EmpService();