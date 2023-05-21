import axios from "axios";

const BASE_API_URL = "http://localhost:8084/codec";
const cplusURL="http://localhost:8084/cplus";
class EmpService {

   async getAllEmp() {
        return axios.get(BASE_API_URL + "/allcode", {}, {headers:{"Authorization": "Bearer" }})
    }
    getEmpById(id) {
        return axios.get(BASE_API_URL + "/student" + id);
    }
    saveEmp(emp) {
            return axios.post(BASE_API_URL + "/save", emp);
        }

        //cplus
        
        async getAllCplus() {
            return axios.get(cplusURL + "/allcode", {}, {headers:{"Authorization": "Bearer" }})
        }
        getCplusById(id) {
            return axios.get(cplusURL + "/student" + id);
        }
        saveCplus(emp) {
                return axios.post(cplusURL + "/save", emp);
            }
}
export default new EmpService();