import { useState, useEffect } from "react";
import axios from "axios";
import { useSelector } from "react-redux";
import authToken from "../utils/authToken";
import Editor from "@monaco-editor/react";
import stubs from "./defaultStubs";
import "./Code.css";
import stuService from ".././services/stu.service";
import empService from "../Codeproblems/code.service";

import { useLocation } from 'react-router-dom';
import { Language } from "@mui/icons-material";
const editorOptions = {
  scrollBeyondLastLine: false,
  fontSize: "20px",
  folding: false,
  //lineDecorationsWidth: 15,
};
const inputOptions = {
  minimap: { enabled: false },
  automaticLayout: true,
  scrollBeyondLastLine: false,
  fontSize: "20px",
  lineDecorationsWidth: 5,
  readOnly: true,
};
const outputOptions = {
  minimap: { enabled: false },
  automaticLayout: true,
  scrollBeyondLastLine: false,
  fontSize: "20px",
  lineDecorationsWidth: 5,
};
 

function Code(props) {

  if (localStorage.jwtToken) {
    authToken(localStorage.jwtToken);
  }
  
  const[total,setTotal]=useState();

  //c
  const [cmark, setcmark] = useState("");
  const [beforecmark, setBeforecmark] = useState("");
//cbasic
const [cmarkb, setcmarkb] = useState("");
  const [beforecmarkb, setBeforecmarkb] = useState("");

  //cbasic
const [cmarki, setcmarki] = useState("");
const [beforecmarki, setBeforecmarki] = useState("");


  //cplus
  const [beforecplusmark, setBeforecplusmark] = useState("");
  const [beforemark, setBeforemark] = useState("");
  //cplus end
  const auth = useSelector((state) => state.auth);
  const username=window.localStorage.getItem("username");
   let uname = username ;
//console.log(uname);
  const [num, setNum] = useState(1);
  function randomNumberInRange(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  const [empList, setEmpList] = useState([]);
  const [input, setInput] = useState("//predefined Testcases");
  const [level, setLevel] = useState("basic");

  const [testcase, setTestcase] = useState("");
  useEffect(() => {
  
   
    deleteEmp(uname);

    getC(uname);
    getCbasicfun(uname);
    getCinterfun(uname);
    getCplus(uname);
  }, []);
  
  const init = () => {
    empService
      .getAllEmp()
      .then((res) => {
        let question;
        let tc;
        setNum(randomNumberInRange(1, res.data.length));
        for (let i = 0; i <= res.data.length; i++) {
          let item = res.data[i];

          let type = item.codetype;
          let cid = item.id;

          if (type === level && cid === num) {
            
            // console.log(item.testcase1);
            // console.log(item.question);
            question = item;

            tc = item.testcase1;
            setTestcase(tc);
            break;
          }
        }
        //res.data=question;
        setEmpList(question);
        setInput(tc);
      })
      .catch((error) => {
        console.log(error);
      });
  };


  const cplus = () => {
    empService
      .getAllCplus()
      .then((res) => {
        let question;
        let tc;
        setNum(randomNumberInRange(1, res.data.length));
        for (let i = 0; i <= res.data.length; i++) {
          let item = res.data[i];

          let type = item.codetype;
          let cid = item.id;

          if (type === level && cid === num) {
          
            question = item;

            tc = item.testcase;
            setTestcase(tc);
            break;
          }
        }
        //res.data=question;
        setEmpList(question);
        setInput(tc);
      })
      .catch((error) => {
        console.log(error);
      });
  };


//total
  const setMark = (uname,points) => {
    stuService
      .setMark(points,uname)
      .then((res) => {
        console.log("c points "+ res.data);
      setTotal(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 
//c
  const setC = (uname,points) => {
    stuService
      .setC(points,uname)
      .then((res) => {
        console.log("cmark  after increment"+ res.data);
      setTotal(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 

  const getC = (name) => {
    stuService
      .getC(name)
      .then((res) => {
        console.log("c before mark"+res.data);
        setBeforecmark(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 
//cbasic

const setCbasicfun = (uname,points) => {
  stuService
    .setCbasic(points,uname)
    .then((res) => {
     // console.log("c basic mark "+ res.data);
    setcmarkb(res.data);
    
    })
    .catch((error) => {
      console.log(error);
    });
}; 

const getCbasicfun = (name) => {
  stuService
    .getCbasic(name)
    .then((res) => {
     // console.log("c basic before mark"+res.data);
      setBeforecmarkb(res.data);
    
    })
    .catch((error) => {
      console.log(error);
    });
}; 

//cinter

const setCinterfun = (uname,points) => {
  stuService
    .setCinter(points,uname)
    .then((res) => {
      console.log("c inter mark "+ res.data);
    setcmarki(res.data);
    
    })
    .catch((error) => {
      console.log(error);
    });
}; 

const getCinterfun = (name) => {
  stuService
    .getCinter(name)
    .then((res) => {
      console.log("c inter before mark"+res.data);
      setBeforecmarki(res.data);
    
    })
    .catch((error) => {
      console.log(error);
    });
}; 


  //cplus
  const setCplus = (uname,points) => {
    stuService
      .setCplus(points,uname)
      .then((res) => {
        console.log("c plus mark "+ res.data);
      setTotal(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 

  const getCplus = (name) => {
    stuService
      .getCplus(name)
      .then((res) => {
        console.log("c plusbefore mark"+res.data);
        setBeforecplusmark(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 




//get before total
  const deleteEmp = (name) => {
    stuService
      .getMark(name)
      .then((res) => {
        console.log("before mark"+res.data);
        setBeforemark(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 

  const [language, setLanguage] = useState("cpp");
  const [langmark, setLangmark] = useState();
  const [code, setCode] = useState("");
  const [output, setOutput] = useState("");
  const [status, setStatus] = useState("");
  const [jobId, setJobId] = useState("");
  const [jobDetails, setJobDetails] = useState(null);
  const [editorMode, setEditorMode] = useState("vs-light");
  const [languageIcon, setLanguageIcon] = useState("./resources/cpp.png");
  const { state } = useLocation();

  useEffect(() => {
    let lang=state.lang
    setLangmark(lang)
    console.log(lang)
    if(lang==="c"){
      init();
    }
    else if(lang==="cpp"){
      cplus();
    }
    setCode(stubs[language]);
    setOutput("// output");
    setLanguageIcon(`./resources/${language}.png`);
  }, [language]);

  const toggleTheme = (idName) => {
    let currentClassName = document.getElementById(idName).className;
    let newClassName = currentClassName;
    if (currentClassName === idName + "-dark") newClassName = idName + "-light";
    else newClassName = idName + "-dark";
    document.getElementById(idName).className = newClassName;
  };

  const handleThemeChange = () => {
    if (editorMode === "vs-light") setEditorMode("vs-dark");
    else setEditorMode("vs-light");
    toggleTheme("App");
    toggleTheme("header");
    toggleTheme("app-name");
    toggleTheme("language-button");
    const themeToggler = document.getElementById("theme-icon");
    let classNames = themeToggler.classList;
    if (classNames.contains("theme-icon-light")) {
      classNames.replace("theme-icon-light", "theme-icon-dark");
      classNames.replace("fa-sun", "fa-moon");
    } else {
      classNames.replace("theme-icon-dark", "theme-icon-light");
      classNames.replace("fa-moon", "fa-sun");
    }
  };

  const handleRefresh = async () => {
    init();
  };
  const handleSubmit = async () => {
    const payload = {
      language: language,
      code: code,
      input: input,
    };

    try {
      setJobId("");
      setStatus("Running");
      setJobDetails(null);
      setOutput(`Code Execution Status: Running`);
      const { data } = await axios.post("http://localhost:5000/run", payload);
      console.log("data",data);
      setJobId(data.jobId);
      let ids=data.jobId
      setJobId(ids);
console.log(ids)
      let intervalId;
//https://code-compilation.onrender.com/run
//http://localhost:5000/run
      intervalId = setInterval(async () => {
        setStatus("Running");
        setOutput(`Code Execution Status: Run `);
        console.log("inside setInterval",ids)
        const { data: dataRes } = await axios.get(
          "http://localhost:5000/status",
          { params: { id: ids } }
        );
        const { success, job, error } = dataRes;
        if (success) 
        {
          setJobDetails(job);
          console.log("inside if");
          const { status: jobStatus, output: jobOutput } = job;
          setStatus(jobStatus);
          console.log("op is",jobOutput);

          console.log("status is",status);

            if (jobStatus === "Success")
            {
              console.log(testcase==parseInt(jobOutput));
              if(jobOutput !== testcase){
              setOutput(`test cased  not passed output is   ${jobOutput}`)
              console.log(testcase,parseInt(jobOutput));
             
            }

            else{
                setOutput(`tc  passed ${testcase}`)
                let m= 0;
//c lang
                if(langmark==="c")
                {
                if(level==="basic")
                {
                m++;
                let fmark= m+beforecmark; 
                console.log ("final c mark"+fmark)
                let bmark=m+beforecmarkb;
                setcmarkb(bmark)
                setCbasicfun(uname,bmark)
                setC(uname,fmark)
                }
                else if(level==="intermediate")
                {
                  //total mark for c lang
                  let fmark= m+5+beforecmark;
                  setcmark( fmark )
                  setC(uname,fmark);
                  //total mark for intermediate level in c
                  let bmark=m+beforecmarki;
                  setcmarki(bmark)
                  setCinterfun(uname,bmark)
                }
                else{
                  let fmark = m+10+beforecmark;
                  setcmark( fmark)
                  setC(uname,fmark);
                  let bmark=m+beforecmarkb;
                  setcmarkb(bmark)
                setCbasicfun(uname,bmark)
                }
              }
              //cplus
              else if(langmark==="cpp"){
                if(level==="basic")
                {
                m++;
                let fmark= m+beforecplusmark; 
                console.log ("final mark"+fmark)
                
                setCplus(uname,fmark);
                }
                else if(level==="intermediate")
                {
                  let fmark= m+5+beforecplusmark;
                 
                  setCplus(uname,fmark);
                }
                else{
                  let fmark = m+10+beforecplusmark;
                  
                  setCplus(uname,fmark);
                }
              }
                props.history.push("/home");
                console.log(m)
             }
          }
           else {
            const errorObject = JSON.parse(jobOutput);
            setOutput(
              `Code Execution Status: ${jobStatus}\n\n${errorObject.stderr}` );
          }
          clearInterval(intervalId);
        } else {
          console.log(dataRes);
          setStatus("Error !!! ");
          console.error(error);
          setOutput(error);
          clearInterval(intervalId);
        }
      }, 1000);
    } catch ({ response }) {
      if (response) {
        const errorMessage = response.data.err.stderr;
        setOutput(errorMessage);
      } else {
        setOutput("Error connecting to server!");
      }
    }
  };

  return (
    <div id="App" className="App-light">
      <div id="header" className="header-light">
        <h3 id="app-name" className="app-name-light">
          <i className="fas fa-solid fa-cube" aria-hidden="true"></i>
          &nbsp; PTU CODE EDITOR
        </h3>

        <div className="nav-right-options">
          <i
            id="theme-icon"
            className="fas fa-solid fa-sun fa-2x nav-icons theme-icon-light"
            aria-hidden="true"
            onClick={handleThemeChange}
          ></i>
        </div>
      </div>
      <div className="secondary-nav-items">
        <button className="btn logo-btn" disabled={true}>
          <img
            src={require(`${languageIcon}`)}
            className="image"
            alt={`${language} icon`}
          />
        </button>
        <button id="language-button" className="language-button-dark">
          <select
            value={level}
            onChange={(e) => {
              setStatus("");
              setJobDetails(null);
              setLevel(e.target.value);
              //setCode(stubs[e.target.value]);
              // setLanguageIcon(`./resources/${language}.png`);
            }}
          >
            <option value={"basic"}>Basic</option>
            <option value={"intermediate"}>Intermediate </option>
            <option value={"adv"}>Advanced </option>
          </select>
        </button>

        <button
          id="language-button"
          className="language-button-dark"
          style={{ marginLeft: ".5rem", marginRight: ".10rem" }}
        >
          <select
            value={language}
            onChange={(e) => {
              setStatus("");
              setJobDetails(null);
              setLanguage(e.target.value);
              setCode(stubs[e.target.value]);
              setLanguageIcon(`./resources/${language}.png`);
            }}
          >
           <option value={"cpp"}>C </option>
            <option value={"python"}>Python</option>
            <option value={"cpp"}>C++ </option>
          </select>
        </button>

        {/* run button */}
        <button className="btn run-btn" onClick={handleSubmit}>
          <i className="fas fa-play fa-fade run-icon" aria-hidden="true"></i>
          &nbsp; Run
        </button>

        <button className="btn run-btn" onClick={handleRefresh}>
          <i className="fas fa-play fa-fade run-icon" aria-hidden="true"></i>
          &nbsp; refresh
        </button>
      </div>

      <div className="std-qn">
        <h4>Question</h4>
        <h3 className="h3">{empList.question}</h3>
      </div>
      <div className="edit">
        <Editor
          height="100%"
          width="100%"
          theme={editorMode}
          defaultLanguage={language}
          defaultValue={code}
          value={code}
          onChange={(e) => setCode(e)}
          options={editorOptions}
          language={language}
        />
      </div>
    <div className="std-input-output">
        <div className="std-input">
          <Editor
            height="100%"
            width="100%"
            theme={editorMode}
            defaultLanguage="plaintext"
            defaultValue={input}
            value={input}
            options={inputOptions}
            // onChange={(e) => setInput(e)}
          />
        </div>
        <div className="std-output">
          <Editor
            height="100%"
            width="100%"
            theme={editorMode}
            defaultLanguage="plaintext"
            defaultValue={"// output"}
            value={output}
            options={outputOptions}
          />
        </div>
      </div>
      <br />
    </div>
  );
}

export default Code;
