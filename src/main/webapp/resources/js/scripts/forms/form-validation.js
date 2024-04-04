/*=========================================================================================
  File Name: form-validation.js
  Description: jquery bootstrap validation js
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy  - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: PIXINVENT
  Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value',
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
        // if (inputGroupValidation) {
        //   inputGroupValidation(form);
        // }
      });
      // bootstrapForm.find('input, textarea').on('focusout', function () {
      //   $(this)
      //     .removeClass('is-valid is-invalid')
      //     .addClass(this.checkValidity() ? 'is-valid' : 'is-invalid');
      //   if (inputGroupValidation) {
      //     inputGroupValidation(this);
      //   }
      // });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'user_name': {
          required: true
        },
        'email_id': {
          required: true,
          email: true
        },
        'basic-default-password': {
          required: true
        },
        'confirm-password': { 
          required: true,
          equalTo: '#basic-default-password'
        },
        'sbu': {
          required: true
        },
        'city': {
          required: true
        },
        'roles': {
          required: true
        },
        'site_name': {
          required: true
        },
        'mobile_number': {
          required: true
        },
        'categories': {
          required: true
        },
        customFile: {
          required: true
        },
        'validationRadiojq': {
          required: true
        },
        'validationBiojq': {
          required: true
        },
        'validationCheck': {
          required: true
        },
		'sbu_code':{
          required: true
        },
		'sbu_name':{
          required: true
        },
		'status':{
          required: true
        },
		'category_name':{
          required: true
        },
		'category_code':{
          required: true
        },
		'state_name':{
          required: true
        },
		'state_code':{
          required: true
        },
		'state':{
          required: true
        },
		'city_name':{
          required: true
        },
		'role_name':{
          required: true
        },
		
		
		
		
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form2'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value',
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
        // if (inputGroupValidation) {
        //   inputGroupValidation(form);
        // }
      });
      // bootstrapForm.find('input, textarea').on('focusout', function () {
      //   $(this)
      //     .removeClass('is-valid is-invalid')
      //     .addClass(this.checkValidity() ? 'is-valid' : 'is-invalid');
      //   if (inputGroupValidation) {
      //     inputGroupValidation(this);
      //   }
      // });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'user_name': {
          required: true
        },
        'email_id': {
          required: true,
          email: true
        },
        'basic-default-password': {
          required: true
        },
        'confirm-password': { 
          required: true,
          equalTo: '#basic-default-password'
        },
        'sbu': {
          required: true
        },
        'city': {
          required: true
        },
        'roles': {
          required: true
        },
        'site_name': {
          required: true
        },
        'mobile_number': {
          required: true
        },
        'categories': {
          required: true
        },
        customFile: {
          required: true
        },
        'validationRadiojq': {
          required: true
        },
        'validationBiojq': {
          required: true
        },
        'validationCheck': {
          required: true
        },
		'sbu_code':{
          required: true
        },
		'sbu_name':{
          required: true
        },
		'status':{
          required: true
        },
		'category_name':{
          required: true
        },
		'category_code':{
          required: true
        },
		'state_name':{
          required: true
        },
		'state_code':{
          required: true
        },
		'state':{
          required: true
        },
		'city_name':{
          required: true
        },
		'role_name':{
          required: true
        },
		'quantity':{
          required: true
        },
		'quantity_measure':{
          required: true
        }
		
		
		
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form-distribute'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value',
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
        // if (inputGroupValidation) {
        //   inputGroupValidation(form);
        // }
      });
      // bootstrapForm.find('input, textarea').on('focusout', function () {
      //   $(this)
      //     .removeClass('is-valid is-invalid')
      //     .addClass(this.checkValidity() ? 'is-valid' : 'is-invalid');
      //   if (inputGroupValidation) {
      //     inputGroupValidation(this);
      //   }
      // });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'total_materials': {
          required: true
        },
        'total_recylable': {
          required: true,
        },
        'total_plastic': {
          required: true
        },
        'total_bags': { 
          required: true,
        },
        'total_glass': {
          required: true
        },
        'total_cardboard': {
          required: true
        },
        'quality_measure_materials': {
          required: true
        },
        'quality_measure_recylable': {
          required: true
        },
        'quality_measure_plastics': {
          required: true
        },
        'quality_measure_bags': {
          required: true
        },
        'quality_measure_glass': {
          required: true
        },
        'quality_measure_cardboard': {
          required: true
        }
		
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form-processing'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value', 
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
        // if (inputGroupValidation) {
        //   inputGroupValidation(form);
        // }
      });
      // bootstrapForm.find('input, textarea').on('focusout', function () {
      //   $(this)
      //     .removeClass('is-valid is-invalid')
      //     .addClass(this.checkValidity() ? 'is-valid' : 'is-invalid');
      //   if (inputGroupValidation) {
      //     inputGroupValidation(this);
      //   }
      // });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'total_waste': {
          required: true
        },
        'total_incieration': {
          required: true,
        },
        'total_autoclave': {
          required: true
        },
        'quantity_measure_waste': { 
          required: true,
        },
        'quantity_measure_incieration': {
          required: true
        },
        'quantity_measure_autoclave': {
          required: true
        }
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form-iwmdisposal'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value', 
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
        // if (inputGroupValidation) {
        //   inputGroupValidation(form);
        // }
      });
      // bootstrapForm.find('input, textarea').on('focusout', function () {
      //   $(this)
      //     .removeClass('is-valid is-invalid')
      //     .addClass(this.checkValidity() ? 'is-valid' : 'is-invalid');
      //   if (inputGroupValidation) {
      //     inputGroupValidation(this);
      //   }
      // });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'disposal_total_waste': {
          required: true
        },
        'disposal_dlf': {
          required: true,
        },
        'disposal_lat': {
          required: true
        },
        'disposal_incineration': { 
          required: true,
        },
        'disposal_afrf': {
          required: true
        },
        'disposal_total_waste_measure': {
          required: true
        },
        'disposal_dlf_measure': {
          required: true
        },
        'disposal_lat_measure': {
          required: true
        },
        'disposal_incineration_measure': {
          required: true
        },
        'disposal_afrf_measure': {
          required: true
        }
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form-iwmleftoverstock'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value', 
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
      });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'stock_total_waste': {
          required: true
        },
        'stock_dlf': {
          required: true,
        },
        'stock_lat': {
          required: true
        },
        'stock_incineration': { 
          required: true,
        },
        'stock_afrf': {
          required: true
        },
        'stock_total_waste_measure': {
          required: true
        },
        'stock_dlf_measure': {
          required: true
        },
        'stock_lat_measure': {
          required: true
        },
        'stock_incineration_measure': {
          required: true
        },
        'stock_afrf_measure': {
          required: true
        }
      }
    });
  }
});

$(function () {
  'use strict';

  var bootstrapForm = $('.needs-validation'),
    jqForm = $('#jquery-val-form-mswprocessing'),
    picker = $('.picker'),
    select = $('.select2');

  // select2
  select.each(function () {
    var $this = $(this);  
    $this.wrap('<div class="position-relative"></div>');
    $this
      .select2({
        placeholder: 'Select value', 
        dropdownParent: $this.parent()
      })
      .change(function () {
        $(this).valid();
      });
  });

  // Picker
  if (picker.length) {
    picker.flatpickr({
      allowInput: true,
      onReady: function (selectedDates, dateStr, instance) {
        if (instance.isMobile) {
          $(instance.mobileInput).attr('step', null);
        }
      }
    });
  }

  // Bootstrap Validation
  // --------------------------------------------------------------------
  if (bootstrapForm.length) {
    Array.prototype.filter.call(bootstrapForm, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          form.classList.add('invalid');
        }
        form.classList.add('was-validated');
        event.preventDefault();
      });
    });
  }

  // jQuery Validation
  // --------------------------------------------------------------------
  if (jqForm.length) {
    jqForm.validate({
      rules: {
        'total_waste': {
          required: true
        },
        'total_rdf': {
          required: true,
        },
        'total_compost': {
          required: true
        },
        'total_inerts': { 
          required: true,
        },
        'total_recylables': {
          required: true
        },
        'quantity_measure_waste': {
          required: true
        },
        'quantity_measure_rdf': {
          required: true
        },
        'quantity_measure_compost': {
          required: true
        },
        'quantity_measure_inerts': {
          required: true
        },
        'quantity_measure_recylabels': {
          required: true
        }
      }
    });
  }
});

