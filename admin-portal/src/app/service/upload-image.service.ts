import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {RequestOptions, Request, RequestMethod} from '@angular/http';


@Injectable({
  providedIn: 'root'
})
export class UploadImageService {
  filesToUpload: Array<File>;

  constructor(private http: HttpClient) { 
    this.filesToUpload=[];
  }

  upload(bookId:number){
    this.makeFileRequest("http://localhost:8080/insertBook/addImage?id="+bookId, [], this.filesToUpload).then((result)=>{
      console.log(result);
    },(error) =>{
      console.log(error);
    });
  }

  fileChangeEvent(fileList: any){
      this.filesToUpload = <Array<File>> fileList.target.files;
     
}

  makeFileRequest(url: string, params:Array<string>, files:Array<File>){
    return new Promise((resolve, reject)=>{
        var formData:any = new FormData();
        var xhr = new XMLHttpRequest();
        for (var i = 0; i<files.length; i++){
          formData.append("uploads[]", files[i], files[i].name);
        }
        xhr.onreadystatechange=function(){
          if(xhr.readyState==4){
            if (xhr.status==200){
              console.log("image uploaded successfully")
            }else {
              reject(xhr.response);
            }
          }
        }
        xhr.open("POST", url, true);
        xhr.setRequestHeader('Authorization', 'Bearer ' +JSON.parse(sessionStorage.getItem('jsessionid')).access_token);
        xhr.send(formData);
    });

  }
}
