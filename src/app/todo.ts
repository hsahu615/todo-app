export class Todo {
    private isActive: boolean = true;
    private description: string;
    private id: number = Math.random();

    constructor(isActive: boolean, description: string) {
        this.description = description;
        this.isActive = isActive;
    }

    setIsActive(isActive: boolean): void {
        this.isActive = isActive;
    }

    getIsActive(): boolean {
        return this.isActive;
    }

    setDescription(description: string): void {
        this.description = description;
    }

    getDescription(): string {
        return this.description;
    }

    getId(): number{
        return this.id;
    }
}