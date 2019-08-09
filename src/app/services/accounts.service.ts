import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Account } from "../Models/Account";
import { DepositAndWithdrawFormat } from '../Models/draw.deposit';
import { TransferFormat } from '../Models/transfer';


    let URL = "http://localhost:8085/accounts/";
    let options = { "headers": new HttpHeaders({ "Content-Type": "application/json" }) }

    @Injectable({
    providedIn: 'root'
    })
    export class AccountService {

        constructor(private http:HttpClient) { 

        }
        
        findById(id:number):Observable<Account>{
            return this.http.get<Account>(URL+"find/"+id);
        }

        findAll():Observable<Account[]>{
            return this.http.get<Account[]>(URL+"")
        }

        add(account:Account):Observable<Account>{
            return this.http.post<Account>(URL+"new",account,options)
        }

        update(account:Account,id:number):Observable<Account>{
            return this.http.put<Account>(URL+"update/"+id,account,options)
        }

        delete(id:number):Observable<Account>{
            return this.http.delete<Account>(URL+"delete/"+id)
        }

        deposit(details:DepositAndWithdrawFormat){
            return this.http.put(URL+"deposit/",details,options)
        }

        withdraw(details:DepositAndWithdrawFormat){
            return this.http.put(URL+"withdraw/",details,options)
        }

        transfer(details:TransferFormat){
            return this.http.put(URL+"transfer/",details,options)
        }


    }