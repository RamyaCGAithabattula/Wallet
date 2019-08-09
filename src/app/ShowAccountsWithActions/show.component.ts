import { Component } from "@angular/core";
import { AccountService } from "../services/accounts.service";
import { Account } from "../Models/Account";


@Component({
    selector:'app-show',
    templateUrl:'show.component.html'
})
export class ShowComponent{
    showUpdate = false
    updatedIndex:number
    hasUpdated = false

    id:number
    phone:string
    name:string
    balance:number

    idDelete:number
    
    accounts:Account[] = []

    ngOnInit(): void {
        this.accounts=[]
    } 

    constructor(private service : AccountService){
        this.accounts = []

        this.service.findAll().subscribe(
            res=>{
                this.accounts=res
            },
            error=>{
                alert("An error has occurred")
            }
        )
    }

    updateAccount(index:number){
        this.showUpdate=true
        this.updatedIndex = index

        this.phone = this.accounts[index].phone
        this.name = this.accounts[index].accountHolder
        this.balance = this.accounts[index].balance

        //this.account = {id:this.id,phone:this.phone,accountHolder:this.name,balance:this.balance}
    }

    deleteAccount(index:number){
        if(confirm("Are you sure you want to delete?")){
            this.idDelete = this.accounts[index].id
            this.accounts.splice(index,1)
            this.service.delete(this.idDelete).subscribe(
                res=>{
                    console.log(res)
                },
                err=>{
                    alert("An error has occurred")
                }
            )
        }
    }

    update(){

        this.accounts[this.updatedIndex].accountHolder = this.name
        this.accounts[this.updatedIndex].phone = this.phone
        this.accounts[this.updatedIndex].balance = this.balance

        this.service.update(this.accounts[this.updatedIndex],this.accounts[this.updatedIndex].id).subscribe(
            res=>{
                console.log(res)
                this.hasUpdated = true
            },
            err=>{
                alert("An error has occurred")
            }
        )

        //alert("updated")
    }
    
    refresh(){
        this.hasUpdated = false
        this.showUpdate = false
    }

}