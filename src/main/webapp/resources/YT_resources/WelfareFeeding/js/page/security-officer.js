import animal_info_datatable from '../datatable/animal-info-datatable.js';
import task_datatable from '../datatable/task-datatable.js';
import animal_details from '../panel/animal-details.js';
import environmental_standard_form from '../form/environmental-standard-form.js';
import room_allocation_standard_form from '../form/room-allocation-standard-form.js';
import common_page from "./common-page.js";

! async function () {
    const element = layui.element;
    await common_page.init('动物生活保障系统');
    let animalNumber = '';
    const functions = [
        ()=>animal_info_datatable.init(d=>animal_details.render(d, {
            environmental_standard_task_btn:true,
            room_allocation_standard_task_btn:true
        })),
        ()=>task_datatable.init(d=>animal_details.render(d, {
            environmental_standard_btn:d=>{
                animalNumber = d;
                element.tabChange('tab', 'environmental-standard');
            },
            room_allocation_standard_btn:d=>{
                animalNumber = d;
                element.tabChange('tab', 'room-allocation-standard');
            },
            task_filter:true
        })),
        ()=>{
            environmental_standard_form.init(animalNumber);
            animalNumber = '';
        },
        ()=>{
            room_allocation_standard_form.init(animalNumber);
            animalNumber = '';
        }]
    // 切换TAB感知以及刷新
    functions[0]();
    element.on('tab', function(data){
        functions[data.index]();
    });

}()